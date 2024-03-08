package com.pisakov.navigation.screenDependencies

import com.pisakov.domain.usecase.GetMovieCollectionsUseCase
import com.pisakov.navigation.AppRouter

interface MainScreenDependencies {

    fun appRouter(): AppRouter

    fun getMovieCollectionsUseCase(): GetMovieCollectionsUseCase
}