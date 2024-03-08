package com.pisakov.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

@Composable
internal fun SetupNavigation(
    navigationChannel: Channel<NavigationIntent>,
    navController: NavController
) {
    val activity = (LocalContext.current as? Activity)
    LaunchedEffect(activity, navController, navigationChannel) {
        navigationChannel.receiveAsFlow().collect { intent ->
            if (activity?.isFinishing == true) {
                return@collect
            }
            when (intent) {
                is NavigationIntent.NavigateBack -> {
                    if (intent.route != null) {
                        navController.popBackStack(intent.route, intent.inclusive)
                    } else {
                        navController.popBackStack()
                    }
                }
                is NavigationIntent.NavigateTo -> {
                    navController.navigate(intent.route) {
                        launchSingleTop = intent.isSingleTop
                        intent.popUpToRoute?.let { popUpToRoute ->
                            popUpTo(popUpToRoute) { inclusive = intent.inclusive }
                        }
                    }
                }
            }
        }
    }
}