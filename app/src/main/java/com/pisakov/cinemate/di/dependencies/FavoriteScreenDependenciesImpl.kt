package com.pisakov.cinemate.di.dependencies

import com.pisakov.domain.usecase.GetMatchesUseCase
import com.pisakov.navigation.screenDependencies.FavoriteScreenDependencies
import javax.inject.Inject

class FavoriteScreenDependenciesImpl @Inject constructor(
    private val getMatchesUseCase: GetMatchesUseCase
) : FavoriteScreenDependencies {

    override fun getMatchesUseCase(): GetMatchesUseCase = getMatchesUseCase
}