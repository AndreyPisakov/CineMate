package com.pisakov.domain.usecase

import com.pisakov.domain.model.MoviesResult
import com.pisakov.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesWithFiltersUseCase @Inject constructor(
    private val repository: MoviesRepository
) {

    suspend fun invoke(
        types: List<String>?,
        years: List<String>?,
        rating: List<String>?,
        genres: List<String>?
    ): Flow<MoviesResult> = repository.getMoviesWithFilters(types, years, rating, genres)
}