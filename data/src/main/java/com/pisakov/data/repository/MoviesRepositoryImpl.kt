package com.pisakov.data.repository

import com.pisakov.data.mapper.mapToMovieModel
import com.pisakov.data.service.KinopoiskMoviesApiService
import com.pisakov.domain.model.MovieModel
import com.pisakov.domain.model.MoviesResult
import com.pisakov.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class MoviesRepositoryImpl @Inject constructor(
    private val apiService: KinopoiskMoviesApiService
) : MoviesRepository {

    private var getMoviesWithFiltersCurrentPage = 1
    private var getMoviesWithFiltersTotalPages = 1

    private var getMoviesBySearchQueryCurrentPage = 1
    private var getMoviesBySearchQueryTotalPages = 1

    override suspend fun getMovieById(id: Int): Result<MovieModel> {
        return runCatching {
            mapToMovieModel(apiService.getMovieById(id))
        }
    }

    override suspend fun getMoviesWithFilters(
        types: List<String>?,
        years: List<String>?,
        rating: List<String>?,
        genres: List<String>?
    ): Flow<MoviesResult> = flow {
        if (getMoviesWithFiltersCurrentPage > getMoviesWithFiltersTotalPages)
            emit(MoviesResult.EmptyResult)
        else {
            runCatching {
                apiService.getMoviesWithFilters(
                    page = getMoviesWithFiltersCurrentPage,
                    types = types,
                    years = years,
                    rating = rating,
                    genres = genres
                ).let {
                    getMoviesWithFiltersCurrentPage++
                    getMoviesWithFiltersTotalPages = it.totalPages
                    it.movies.map(::mapToMovieModel)
                }
            }
                .onSuccess { emit(MoviesResult.Success(it)) }
                .onFailure { emit(MoviesResult.Failure(it)) }
        }
    }

    override suspend fun getMoviesFromCollection(collection: String): Result<List<MovieModel>> {
        return runCatching {
            apiService.getMoviesFromCollection(
                collection = listOf(collection)
            ).movies.map(::mapToMovieModel)
        }
    }

    override suspend fun getMoviesBySearchQuery(searchQuery: String): Flow<MoviesResult> = flow {
        if (getMoviesBySearchQueryCurrentPage > getMoviesBySearchQueryTotalPages)
            emit(MoviesResult.EmptyResult)
        else {
            runCatching {
                apiService.getMoviesBySearchQuery(
                    page = getMoviesWithFiltersCurrentPage,
                    searchQuery = searchQuery
                ).let {
                    getMoviesBySearchQueryCurrentPage++
                    getMoviesBySearchQueryTotalPages = it.totalPages
                    it.movies.map(::mapToMovieModel)
                }
            }
                .onSuccess { emit(MoviesResult.Success(it)) }
                .onFailure { emit(MoviesResult.Failure(it)) }
        }
    }
}