package com.pisakov.cinemate.containerScreen

import androidx.lifecycle.ViewModel
import com.pisakov.navigation.AppRouter
import com.pisakov.navigation.FavoriteScreenDestination
import com.pisakov.navigation.MainScreenDestination
import com.pisakov.navigation.ProfileScreenDestination
import com.pisakov.navigation.SearchScreenDestination
import javax.inject.Inject

class ContainerViewModel @Inject constructor(
    private val appRouter: AppRouter
) : ViewModel() {

    val navigationChannel = appRouter.navigationChannel

    fun navigateToMainScreen() {
        appRouter.tryNavigateTo(
            route = MainScreenDestination(),
            popUpToRoute = MainScreenDestination.route,
            isSingleTop = true
        )
    }

    fun navigateToSearchScreen() {
        appRouter.tryNavigateTo(
            route = SearchScreenDestination(),
            popUpToRoute = SearchScreenDestination.route,
            isSingleTop = true
        )
    }

    fun navigateToFavoriteScreen() {
        appRouter.tryNavigateTo(
            route = FavoriteScreenDestination(),
            popUpToRoute = FavoriteScreenDestination.route,
            isSingleTop = true
        )
    }

    fun navigateToProfileScreen() {
        appRouter.tryNavigateTo(
            route = ProfileScreenDestination(),
            popUpToRoute = ProfileScreenDestination.route,
            isSingleTop = true
        )
    }
}