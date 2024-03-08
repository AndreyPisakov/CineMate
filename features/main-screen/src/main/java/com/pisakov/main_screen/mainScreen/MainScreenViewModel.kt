package com.pisakov.main_screen.mainScreen

import androidx.lifecycle.ViewModel
import com.pisakov.navigation.CreateSessionDestination
import com.pisakov.navigation.JoinToSessionDestination
import com.pisakov.navigation.screenDependencies.MainScreenDependencies
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