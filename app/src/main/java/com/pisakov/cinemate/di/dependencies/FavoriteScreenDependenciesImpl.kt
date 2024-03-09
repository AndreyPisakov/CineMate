package com.pisakov.cinemate.di.dependencies

import com.pisakov.domain.usecase.GetMatchesUseCase
import com.pisakov.favorite.di.FavoriteScreenDependencies
import com.pisakov.navigation.AppRouter
import javax.inject.Inject

class FavoriteScreenDependenciesImpl @Inject constructor(
    private val appRouter: AppRouter,
    private val getMatchesUseCase: GetMatchesUseCase,
) : FavoriteScreenDependencies {

    override fun appRouter(): AppRouter = appRouter

    override fun getMatchesUseCase(): GetMatchesUseCase = getMatchesUseCase
}