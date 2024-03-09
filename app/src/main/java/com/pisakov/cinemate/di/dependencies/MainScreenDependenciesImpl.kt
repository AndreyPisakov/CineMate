package com.pisakov.cinemate.di.dependencies

import com.pisakov.domain.usecase.GetMovieCollectionsUseCase
import com.pisakov.main_screen.di.MainScreenDependencies
import com.pisakov.navigation.AppRouter
import javax.inject.Inject

class MainScreenDependenciesImpl @Inject constructor(
    private val appRouter: AppRouter,
    private val getMovieCollectionsUseCase: GetMovieCollectionsUseCase,
) : MainScreenDependencies {

    override fun appRouter(): AppRouter = appRouter

    override fun getMovieCollectionsUseCase(): GetMovieCollectionsUseCase = getMovieCollectionsUseCase
}