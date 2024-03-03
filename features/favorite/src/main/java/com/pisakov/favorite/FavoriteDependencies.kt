package com.pisakov.favorite

import com.pisakov.domain.usecase.GetMatchesUseCase

interface FavoriteDependencies {

    fun getMatchesUseCase(): GetMatchesUseCase
}