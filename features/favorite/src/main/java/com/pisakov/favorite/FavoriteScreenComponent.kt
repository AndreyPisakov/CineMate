package com.pisakov.favorite

import com.pisakov.navigation.screenDependencies.FavoriteScreenDependencies
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