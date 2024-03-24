package com.pisakov.domain.repository

import com.pisakov.domain.model.MovieModel
import com.pisakov.domain.model.MoviesResult
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    suspend fun getMovieById(id: Int): Result<MovieModel>

    suspend fun getMoviesWithFilters(
        types: List<String>?,
        years: List<String>?,
        rating: List<String>?,
        genres: List<String>?
    ): Flow<MoviesResult>

    suspend fun getMoviesFromCollection(collections: List<String>): Result<List<MovieModel>>

    suspend fun getMoviesBySearchQuery(searchQuery: String): Flow<MoviesResult>
}