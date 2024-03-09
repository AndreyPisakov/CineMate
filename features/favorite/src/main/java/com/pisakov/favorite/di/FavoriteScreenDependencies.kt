package com.pisakov.favorite.di

import com.pisakov.domain.usecase.GetMatchesUseCase
import com.pisakov.navigation.AppRouter

interface FavoriteScreenDependencies {

    fun appRouter(): AppRouter

    fun getMatchesUseCase(): GetMatchesUseCase
}