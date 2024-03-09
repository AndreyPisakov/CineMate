package com.pisakov.search.di

import com.pisakov.search.SearchScreenViewModel
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