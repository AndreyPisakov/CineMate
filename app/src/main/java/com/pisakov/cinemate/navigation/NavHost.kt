package com.pisakov.cinemate.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pisakov.favorite.FavoriteScreen
import com.pisakov.main_screen.MainScreen
import com.pisakov.profile.ProfileScreen
import com.pisakov.search.SearchScreen

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Destination.MainScreen.fullRoute
    ) {
        composable(destination = Destination.MainScreen) { MainScreen() }
        composable(destination = Destination.SearchScreen) { SearchScreen() }
        composable(destination = Destination.FavoriteScreen) { FavoriteScreen() }
        composable(destination = Destination.ProfileScreen) { ProfileScreen() }
    }
}

fun NavGraphBuilder.composable(
    destination: Destination,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable(
        route = destination.fullRoute,
        arguments = arguments,
        deepLinks = deepLinks,
        content = content
    )
}