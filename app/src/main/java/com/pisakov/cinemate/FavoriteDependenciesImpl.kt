package com.pisakov.cinemate

import com.pisakov.domain.usecase.GetMatchesUseCase
import com.pisakov.favorite.FavoriteDependencies
import javax.inject.Inject

class FavoriteDependenciesImpl @Inject constructor(
    private val getMatchesUseCase: GetMatchesUseCase
) : FavoriteDependencies {

    override fun getMatchesUseCase(): GetMatchesUseCase = getMatchesUseCase
}