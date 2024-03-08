package com.pisakov.main_screen.di

import com.pisakov.main_screen.createSessionScreen.CreateSessionScreenViewModel
import com.pisakov.main_screen.joinToSessionScreen.JoinToSessionScreenViewModel
import com.pisakov.main_screen.mainScreen.MainScreenViewModel
import com.pisakov.navigation.screenDependencies.MainScreenDependencies
import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [MainScreenDependencies::class])
@Singleton
interface MainScreenComponent {

    fun getMainScreenViewModel(): MainScreenViewModel

    fun getCreateSessionViewModel(): CreateSessionScreenViewModel

    fun getJoinToSessionScreenViewModel(): JoinToSessionScreenViewModel

    @Component.Factory
    interface Factory {

        fun create(
            mainScreenDependencies: MainScreenDependencies
        ): MainScreenComponent
    }
}