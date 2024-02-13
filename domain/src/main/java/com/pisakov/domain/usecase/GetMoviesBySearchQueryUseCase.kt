package com.pisakov.domain.usecase

import com.pisakov.domain.model.MoviesResult
import com.pisakov.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesBySearchQueryUseCase @Inject constructor(
    private val repository: MoviesRepository
) {

    suspend fun invoke(
        searchQuery: String
    ): Flow<MoviesResult> = repository.getMoviesBySearchQuery(searchQuery)
}