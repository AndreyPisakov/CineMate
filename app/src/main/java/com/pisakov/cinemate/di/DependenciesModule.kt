package com.pisakov.cinemate.di

import com.pisakov.cinemate.FavoriteDependenciesImpl
import com.pisakov.favorite.FavoriteDependencies
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DependenciesModule {

    @Binds
    fun bindFavoriteDependencies(impl: FavoriteDependenciesImpl): FavoriteDependencies
}