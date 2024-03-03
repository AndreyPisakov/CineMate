package com.pisakov.cinemate.mainScreen

import androidx.lifecycle.ViewModel
import com.pisakov.cinemate.navigation.AppRouter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appRouter: AppRouter
) : ViewModel() {

    val navigationChannel = appRouter.navigationChannel

    fun onBottomNavigationClick(route: String) {
        appRouter.tryNavigateTo(
            route = route,
            popUpToRoute = route,
            isSingleTop = true
        )
    }
}