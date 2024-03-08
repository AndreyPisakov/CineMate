package com.pisakov.data.di

import com.pisakov.domain.repository.CollectionsRepository
import com.pisakov.domain.repository.MoviesRepository
import com.pisakov.domain.repository.SessionRepository
import dagger.Component
import javax.inject.Inject
import javax.inject.Scope

@DataScope
@Component(modules = [NetworkModule::class, RepositoryModule::class, DatabaseModule::class])
interface DataComponent {

    fun provideRepositories(): RepositoryProvider

    @Component.Factory
    interface Factory {

        fun create(): DataComponent
    }
}

class RepositoryProvider @Inject constructor(
    val collectionsRepository: CollectionsRepository,
    val moviesRepository: MoviesRepository,
    val sessionRepository: SessionRepository
)

@Scope
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class DataScope