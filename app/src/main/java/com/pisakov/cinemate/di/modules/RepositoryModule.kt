package com.pisakov.cinemate.di.modules

import com.pisakov.data.di.RepositoryProvider
import com.pisakov.domain.repository.CollectionsRepository
import com.pisakov.domain.repository.MoviesRepository
import com.pisakov.domain.repository.SessionRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun bindMoviesRepository(repositoryProvider: RepositoryProvider): MoviesRepository = repositoryProvider.moviesRepository

    @Provides
    @Singleton
    fun bindCollectionsRepository(repositoryProvider: RepositoryProvider): CollectionsRepository = repositoryProvider.collectionsRepository

    @Provides
    @Singleton
    fun bindSessionRepository(repositoryProvider: RepositoryProvider): SessionRepository = repositoryProvider.sessionRepository
}