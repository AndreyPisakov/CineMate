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
import com.pisakov.cinemate.mainScreen.HomeScreen
import com.pisakov.cinemate.mainScreen.MessagesScreen
import com.pisakov.cinemate.mainScreen.UserDetailsScreen
import com.pisakov.cinemate.mainScreen.UsersScreen

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Destination.HomeScreen.fullRoute
    ) {
        composable(destination = Destination.HomeScreen) { HomeScreen() }
        composable(destination = Destination.SearchScreen) { UsersScreen() }
        composable(destination = Destination.FavoriteScreen) { UserDetailsScreen() }
        composable(destination = Destination.ProfileScreen) { MessagesScreen() }
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