package com.pisakov.data.repository

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.pisakov.domain.model.MatchModel
import com.pisakov.domain.model.SessionKey
import com.pisakov.domain.repository.SessionRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

class SessionRepositoryImpl @Inject constructor(
    private val database: FirebaseDatabase
) : SessionRepository {

    private var sessionKey: SessionKey? = null
    private val matchesFlow = MutableSharedFlow<Result<MatchModel>>()

    private val matches = mutableListOf<MatchModel>()
    private val usersLikes = mutableMapOf<String, MutableList<Int>>()

    override fun createSession(userName: String, moviesId: List<Int>): Result<SessionKey> {
        return runCatching {
            createSessionKey().also {sessionKey ->
                this@SessionRepositoryImpl.sessionKey = sessionKey
                observeUsersLikes(sessionKey)
                database.getReference(sessionKey.key).child(USERS).setValue(userName)
                database.getReference(sessionKey.key).child(MOVIES).setValue(moviesId)
            }
        }
    }

    override fun joinToSession(userName: String, sessionKey: SessionKey): Result<Unit> {
        return runCatching {
            this@SessionRepositoryImpl.sessionKey = sessionKey
            database.getReference(sessionKey.key).child(USERS).setValue(userName)
        }
    }

    override fun getMatches(): SharedFlow<Result<MatchModel>> {
        runCatching {
            sessionKey?.let {
                database.getReference(it.key).child(MATCHES).addValueEventListener(object: ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        matchesFlow.tryEmit(
                            runCatching { snapshot.children.last().value as MatchModel }
                        )
                    }

                    override fun onCancelled(error: DatabaseError) {
                        matchesFlow.tryEmit(Result.failure(error.toException().cause ?: Throwable()))
                    }
                })
            }
        }
        return matchesFlow
    }

    override fun setMovieAsLiked(userName: String, movieId: Int): Result<Unit> {
        return runCatching {
            sessionKey?.let {
                database.getReference(it.key).child(USERS).child(userName).setValue(movieId)
            }
        }
    }

    private fun createSessionKey(): SessionKey {
        TODO()
    }

    private fun observeUsersLikes(sessionKey: SessionKey) {
        database.getReference(sessionKey.key).child(USERS).addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.children.last().key?.let { newUser ->
                    usersLikes[newUser] = mutableListOf()
                    observeUserLikes(sessionKey, newUser)
                }
            }
            override fun onCancelled(error: DatabaseError) {}
        })
    }

    private fun observeUserLikes(sessionKey: SessionKey, newUser: String) {
        database.getReference(sessionKey.key).child(USERS).child(newUser).addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                matchesFlow.tryEmit(runCatching {
                    val newLikedMovie = snapshot.children.last().value as Int

                    if (matches.firstOrNull { it.movieId == newLikedMovie } == null) {
                        usersLikes.keys.forEach { user ->
                            if (usersLikes[user]?.firstOrNull { it == newLikedMovie } != null) {
                                usersLikes[newUser]?.add(newLikedMovie)
                                return@runCatching MatchModel(Pair(user, newUser), newLikedMovie).also { newMatch ->
                                    matches.add(newMatch)
                                }
                            }
                        }
                    }
                    return
                })
            }
            override fun onCancelled(error: DatabaseError) {}
        })
    }

    companion object {
        private const val USERS = "users"
        private const val MOVIES = "movies"
        private const val MATCHES = "matches"
    }
}