package com.pisakov.main_screen.di

import com.pisakov.domain.usecase.GetMovieCollectionsUseCase
import com.pisakov.navigation.AppRouter

interface MainScreenDependencies {

    fun appRouter(): AppRouter

    fun getMovieCollectionsUseCase(): GetMovieCollectionsUseCase
}