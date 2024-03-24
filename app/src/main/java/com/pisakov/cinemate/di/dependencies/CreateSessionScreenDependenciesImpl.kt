package com.pisakov.cinemate.di.dependencies

import com.pisakov.auth.GetUserRepository
import com.pisakov.createSessionScreen.api.CreateSessionScreenImpl
import com.pisakov.createSessionScreen.di.CreateSessionScreenDependencies
import com.pisakov.domain.usecase.CreateSessionUseCase
import com.pisakov.domain.usecase.GetMovieCollectionsUseCase
import com.pisakov.domain.usecase.GetMoviesFromCollectionUseCase
import javax.inject.Inject

class CreateSessionScreenDependenciesImpl @Inject constructor(
    private val createSessionScreenImpl: CreateSessionScreenImpl,
    private val getMovieCollectionsUseCase: GetMovieCollectionsUseCase,
    private val getMoviesFromCollectionUseCase: GetMoviesFromCollectionUseCase,
    private val  getUserRepository: GetUserRepository,
    private val createSessionUseCase: CreateSessionUseCase
) : CreateSessionScreenDependencies {

    override fun createSessionScreenImpl(): CreateSessionScreenImpl = createSessionScreenImpl

    override fun getMovieCollectionsUseCase(): GetMovieCollectionsUseCase = getMovieCollectionsUseCase

    override fun getMoviesFromCollectionUseCase(): GetMoviesFromCollectionUseCase = getMoviesFromCollectionUseCase

    override fun getUserRepository(): GetUserRepository = getUserRepository

    override fun createSessionUseCase(): CreateSessionUseCase = createSessionUseCase
}