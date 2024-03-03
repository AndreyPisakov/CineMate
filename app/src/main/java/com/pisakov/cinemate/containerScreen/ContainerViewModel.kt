package com.pisakov.cinemate.containerScreen

import androidx.lifecycle.ViewModel
import com.pisakov.cinemate.Destination
import com.pisakov.favorite.FavoriteDependencies
import com.pisakov.navigation.AppRouter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContainerViewModel @Inject constructor(
    private val appRouter: AppRouter,
    private val favoriteDependencies: FavoriteDependencies
) : ViewModel() {

    val navigationChannel = appRouter.navigationChannel

    fun navigateToMainScreen() {
        appRouter.tryNavigateTo(
            route = Destination.MainScreen(),
            popUpToRoute = Destination.MainScreen.route,
            isSingleTop = true
        )
    }

    fun navigateToSearchScreen() {
        appRouter.tryNavigateTo(
            route = Destination.SearchScreen(),
            popUpToRoute = Destination.SearchScreen.route,
            isSingleTop = true
        )
    }

    fun navigateToFavoriteScreen() {
        appRouter.tryNavigateTo(
            route = Destination.FavoriteScreen(favoriteDependencies),
            popUpToRoute = Destination.FavoriteScreen.route,
            isSingleTop = true
        )
    }

    fun navigateToProfileScreen() {
        appRouter.tryNavigateTo(
            route = Destination.ProfileScreen(),
            popUpToRoute = Destination.ProfileScreen.route,
            isSingleTop = true
        )
    }
}