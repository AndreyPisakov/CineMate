package com.pisakov.domain.usecase

import com.pisakov.domain.model.MovieModel
import com.pisakov.domain.repository.MoviesRepository
import javax.inject.Inject

class GetMoviesFromCollectionUseCase @Inject constructor(
    private val repository: MoviesRepository
) {

    suspend fun invoke(collections: List<String>): Result<List<MovieModel>> = repository.getMoviesFromCollection(collections)
}