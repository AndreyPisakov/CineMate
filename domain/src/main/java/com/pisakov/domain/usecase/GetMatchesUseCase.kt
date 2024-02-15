package com.pisakov.domain.usecase

import com.pisakov.domain.model.MatchModel
import com.pisakov.domain.repository.SessionRepository
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

class GetMatchesUseCase @Inject constructor(
    private val repository: SessionRepository
) {

    fun invoke(): SharedFlow<Result<MatchModel>> = repository.getMatches()
}