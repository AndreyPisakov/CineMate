package com.pisakov.domain.usecase

import com.pisakov.domain.model.MovieModel
import com.pisakov.domain.model.SessionKey
import com.pisakov.domain.repository.SessionRepository
import javax.inject.Inject

class CreateSessionUseCase @Inject constructor(
    private val repository: SessionRepository
) {

    fun invoke(userName: String, userId: String, movies: List<MovieModel>): Result<SessionKey> {
        return repository.createSession(userName, userId, movies)
    }
}