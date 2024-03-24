package com.pisakov.createSessionScreen.di

import com.pisakov.auth.GetUserRepository
import com.pisakov.createSessionScreen.api.CreateSessionScreenImpl
import com.pisakov.domain.usecase.CreateSessionUseCase
import com.pisakov.domain.usecase.GetMovieCollectionsUseCase
import com.pisakov.domain.usecase.GetMoviesFromCollectionUseCase

interface CreateSessionScreenDependencies {

    fun createSessionScreenImpl(): CreateSessionScreenImpl

    fun getMovieCollectionsUseCase(): GetMovieCollectionsUseCase

    fun getMoviesFromCollectionUseCase(): GetMoviesFromCollectionUseCase

    fun getUserRepository(): GetUserRepository

    fun createSessionUseCase(): CreateSessionUseCase
}