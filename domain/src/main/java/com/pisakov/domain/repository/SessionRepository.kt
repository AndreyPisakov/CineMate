package com.pisakov.domain.repository

import com.pisakov.domain.model.MatchModel
import com.pisakov.domain.model.SessionKey
import kotlinx.coroutines.flow.SharedFlow

interface SessionRepository {

    fun createSession(userName: String, moviesId: List<Int>): Result<SessionKey>

    fun joinToSession(userName: String, sessionKey: SessionKey): Result<Unit>

    fun getMatches(): SharedFlow<Result<MatchModel>>

    fun setMovieAsLiked(userName: String, movieId: Int): Result<Unit>
}