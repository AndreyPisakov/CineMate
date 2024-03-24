package com.pisakov.createSessionScreen.di

import com.pisakov.createSessionScreen.CreateSessionScreenViewModel
import com.pisakov.createSessionScreen.collectionsScreen.CollectionsScreenViewModel
import com.pisakov.createSessionScreen.filtersScreen.FiltersScreenViewModel
import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [CreateSessionScreenDependencies::class])
@Singleton
interface CreateSessionScreenComponent {

    fun getCreateSessionViewModel(): CreateSessionScreenViewModel

    fun getFiltersScreenViewModel(): FiltersScreenViewModel

    fun getCollectionsScreenViewModel(): CollectionsScreenViewModel

    @Component.Factory
    interface Factory {

        fun create(
            createSessionScreenDependencies: CreateSessionScreenDependencies
        ): CreateSessionScreenComponent
    }
}