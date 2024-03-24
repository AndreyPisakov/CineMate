package com.pisakov.createSessionScreen

import androidx.lifecycle.ViewModel
import com.pisakov.auth.GetUserRepository
import com.pisakov.domain.model.MovieModel
import com.pisakov.domain.usecase.CreateSessionUseCase
import timber.log.Timber
import javax.inject.Inject

class CreateSessionScreenViewModel @Inject constructor(
    private val getUserRepository: GetUserRepository,
    private val createSessionUseCase: CreateSessionUseCase
) : ViewModel() {

    fun createSession(movies: List<MovieModel>) {
        val user = getUserRepository.getUser()
        createSessionUseCase.invoke(user.name, user.uid, movies)
            .onSuccess {
                Timber.d("SessionKey: ${ it.key }")
            }
            .onFailure {
                TODO()
            }
    }
}