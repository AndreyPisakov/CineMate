package com.pisakov.favorite.di

import com.pisakov.favorite.FavoriteScreenViewModel
import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [FavoriteScreenDependencies::class])
@Singleton
interface FavoriteScreenComponent {

    fun getFavoriteScreenViewModel(): FavoriteScreenViewModel

    @Component.Factory
    interface Factory {

        fun create(
            favoriteScreenDependencies: FavoriteScreenDependencies
        ): FavoriteScreenComponent
    }
}