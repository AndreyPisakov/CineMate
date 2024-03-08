package com.pisakov.cinemate.di.modules

import com.pisakov.cinemate.di.dependencies.FavoriteScreenDependenciesImpl
import com.pisakov.cinemate.di.dependencies.MainScreenDependenciesImpl
import com.pisakov.cinemate.di.dependencies.ProfileScreenDependenciesImpl
import com.pisakov.cinemate.di.dependencies.SearchScreenDependenciesImpl
import com.pisakov.navigation.screenDependencies.FavoriteScreenDependencies
import com.pisakov.navigation.screenDependencies.MainScreenDependencies
import com.pisakov.navigation.screenDependencies.ProfileScreenDependencies
import com.pisakov.navigation.screenDependencies.SearchScreenDependencies
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DependenciesModule {

    @Binds
    @Singleton
    fun bindMainScreenDependencies(impl: MainScreenDependenciesImpl): MainScreenDependencies

    @Binds
    @Singleton
    fun bindSearchScreenDependencies(impl: SearchScreenDependenciesImpl): SearchScreenDependencies

    @Binds
    @Singleton
    fun bindFavoriteScreenDependencies(impl: FavoriteScreenDependenciesImpl): FavoriteScreenDependencies

    @Binds
    @Singleton
    fun bindProfileScreenDependencies(impl: ProfileScreenDependenciesImpl): ProfileScreenDependencies
}