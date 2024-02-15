package com.pisakov.domain.usecase

import com.pisakov.domain.repository.SessionRepository
import javax.inject.Inject

class SetMovieAsLikedUseCase @Inject constructor(
    private val repository: SessionRepository
) {

    fun invoke(userName: String, movieId: Int): Result<Unit> {
        return repository.setMovieAsLiked(userName, movieId)
    }
}