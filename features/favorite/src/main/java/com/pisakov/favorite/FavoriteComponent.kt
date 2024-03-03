package com.pisakov.favorite

import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [FavoriteDependencies::class]
)
@Singleton
internal interface FavoriteComponent {

    @Component.Factory
    interface Factory {

        fun create(
            favoriteDependencies: FavoriteDependencies
        ): FavoriteComponent
    }
}