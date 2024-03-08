package com.pisakov.data.di

import com.pisakov.data.repository.CollectionsRepositoryImpl
import com.pisakov.data.repository.MoviesRepositoryImpl
import com.pisakov.data.repository.SessionRepositoryImpl
import com.pisakov.domain.repository.CollectionsRepository
import com.pisakov.domain.repository.MoviesRepository
import com.pisakov.domain.repository.SessionRepository
import dagger.Binds
import dagger.Module

@Module
internal interface RepositoryModule {

    @Binds
    @DataScope
    fun bindCollectionsRepository(impl: CollectionsRepositoryImpl): CollectionsRepository

    @Binds
    @DataScope
    fun bindMoviesRepository(impl: MoviesRepositoryImpl): MoviesRepository

    @Binds
    @DataScope
    fun bindSessionRepository(impl: SessionRepositoryImpl): SessionRepository
}