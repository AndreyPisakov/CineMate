package com.pisakov.cinemate.di.modules

import com.pisakov.cinemate.di.dependencies.CreateSessionScreenDependenciesImpl
import com.pisakov.cinemate.di.dependencies.FavoriteScreenDependenciesImpl
import com.pisakov.cinemate.di.dependencies.MainScreenDependenciesImpl
import com.pisakov.cinemate.di.dependencies.ProfileScreenDependenciesImpl
import com.pisakov.cinemate.di.dependencies.SearchScreenDependenciesImpl
import com.pisakov.createSessionScreen.di.CreateSessionScreenDependencies
import com.pisakov.favorite.di.FavoriteScreenDependencies
import com.pisakov.mainScreen.di.MainScreenDependencies
import com.pisakov.profile.di.ProfileScreenDependencies
import com.pisakov.search.di.SearchScreenDependencies
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

    @Binds
    @Singleton
    fun bindCreateSessionScreenDependencies(impl: CreateSessionScreenDependenciesImpl): CreateSessionScreenDependencies
}