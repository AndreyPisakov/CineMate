package com.pisakov.domain.usecase

import com.pisakov.domain.model.MovieModel
import com.pisakov.domain.repository.MoviesRepository
import javax.inject.Inject

class GetMovieByIdUseCase @Inject constructor(
    private val repository: MoviesRepository
) {

    suspend fun invoke(id: Int): Result<MovieModel> = repository.getMovieById(id)
}