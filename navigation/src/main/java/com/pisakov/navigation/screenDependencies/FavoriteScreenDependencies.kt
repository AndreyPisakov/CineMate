package com.pisakov.navigation.screenDependencies

import com.pisakov.domain.usecase.GetMatchesUseCase

interface FavoriteScreenDependencies {

    fun getMatchesUseCase(): GetMatchesUseCase
}