package com.pisakov.mainScreen.di

import com.pisakov.mainScreen.joinToSessionScreen.JoinToSessionScreenViewModel
import com.pisakov.mainScreen.mainScreen.MainScreenViewModel
import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [MainScreenDependencies::class])
@Singleton
interface MainScreenComponent {

    fun getMainScreenViewModel(): MainScreenViewModel

    fun getJoinToSessionScreenViewModel(): JoinToSessionScreenViewModel

    @Component.Factory
    interface Factory {

        fun create(
            mainScreenDependencies: MainScreenDependencies
        ): MainScreenComponent
    }
}