package com.pisakov.main_screen.mainScreen

import androidx.lifecycle.ViewModel
import com.pisakov.main_screen.di.MainScreenDependencies
import com.pisakov.navigation.CreateSessionDestination
import com.pisakov.navigation.JoinToSessionDestination
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val mainScreenDependencies: MainScreenDependencies
) : ViewModel() {

    fun navigateToCreateSessionScreen() {
        mainScreenDependencies.appRouter().tryNavigateTo(route = CreateSessionDestination())
    }

    fun navigateToJoinToSessionScreen() {
        mainScreenDependencies.appRouter().tryNavigateTo(route = JoinToSessionDestination())
    }
}