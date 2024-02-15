package com.pisakov.domain.usecase

import com.pisakov.domain.model.SessionKey
import com.pisakov.domain.repository.SessionRepository
import javax.inject.Inject

class JoinToSessionUseCase @Inject constructor(
    private val repository: SessionRepository
) {

    fun invoke(userName: String, sessionKey: SessionKey): Result<Unit> {
        return repository.joinToSession(userName, sessionKey)
    }
}