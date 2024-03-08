package com.pisakov.navigation

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.channels.Channel

@SuppressLint("RestrictedApi")
@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    startDestination: String,
    navigationChannel: Channel<NavigationIntent>,
    composableModels: List<ComposableModel>
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        composableModels.forEach { composableModel ->
            composable(
                destination = composableModel.destination,
                content = composableModel.content
            )
        }
    }
    SetupNavigation(
        navigationChannel = navigationChannel,
        navController = navController
    )
}

data class ComposableModel(
    val destination: String,
    val content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
)
