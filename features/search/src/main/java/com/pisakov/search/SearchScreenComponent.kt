package com.pisakov.search

import com.pisakov.navigation.screenDependencies.SearchScreenDependencies
import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [SearchScreenDependencies::class])
@Singleton
interface SearchScreenComponent {

    fun getSearchScreenViewModel(): SearchScreenViewModel

    @Component.Factory
    interface Factory {

        fun create(
            searchScreenDependencies: SearchScreenDependencies
        ): SearchScreenComponent
    }
}