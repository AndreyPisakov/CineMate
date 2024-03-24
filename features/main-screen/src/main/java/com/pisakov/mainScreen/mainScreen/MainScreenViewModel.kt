package com.pisakov.mainScreen.mainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pisakov.createSessionScreen.api.CreateSessionScreenApi
import com.pisakov.mainScreen.di.MainScreenDependencies
import com.pisakov.navigation.JoinToSessionDestination
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val mainScreenDependencies: MainScreenDependencies,
    private val createSessionScreenApi: CreateSessionScreenApi
) : ViewModel() {

    internal fun navigateToCreateSessionScreen() {
        createSessionScreenApi.execute(null)
        subscribeToCreateSessionScreenResult()
    }

    internal fun navigateToJoinToSessionScreen() {
        mainScreenDependencies.appRouter().tryNavigateTo(route = JoinToSessionDestination())
    }

    private fun subscribeToCreateSessionScreenResult() {
        createSessionScreenApi.featureResult
            .onEach {
                TODO()
            }.launchIn(viewModelScope)
    }
}