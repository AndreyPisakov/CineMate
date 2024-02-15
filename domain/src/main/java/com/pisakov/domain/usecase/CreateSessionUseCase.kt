package com.pisakov.domain.usecase

import com.pisakov.domain.model.SessionKey
import com.pisakov.domain.repository.SessionRepository
import javax.inject.Inject

class CreateSessionUseCase @Inject constructor(
    private val repository: SessionRepository
) {

    fun invoke(userName: String, moviesId: List<Int>): Result<SessionKey> {
        return repository.createSession(userName, moviesId)
    }
}