package com.pisakov.cinemate.containerScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pisakov.cinemate.Destination
import com.pisakov.cinemate.ui.theme.CineMateTheme
import com.pisakov.favorite.FavoriteScreen
import com.pisakov.main_screen.MainScreen
import com.pisakov.navigation.ComposableModel
import com.pisakov.navigation.NavigationHost
import com.pisakov.navigation.bottomNavigationItemIsSelected
import com.pisakov.profile.ProfileScreen
import com.pisakov.search.SearchScreen

@Composable
fun ContainerScreen(mainViewModel: ContainerViewModel = viewModel()) {
    CineMateTheme {
        Scaffold(
            bottomBar = {
                BottomNavigation(
                    modifier = Modifier.height(50.dp),
                    backgroundColor = Color.DarkGray
                ) {
                    Row {
                        BottomNavigationItems.values().forEach {
                            BottomNavigationItem(
                                label = { Text(text = it.title, fontSize = 12.sp) },
                                icon = { Icon(it.icon, contentDescription = null) },
                                selected = bottomNavigationItemIsSelected(route = it.route),
                                selectedContentColor = Color.White,
                                unselectedContentColor = Color.Gray,
                                onClick = {
                                    when (it.route) {
                                        BottomNavigationItems.MAIN.route -> mainViewModel.navigateToMainScreen()
                                        BottomNavigationItems.SEARCH.route -> mainViewModel.navigateToSearchScreen()
                                        BottomNavigationItems.FAVORITE.route -> mainViewModel.navigateToFavoriteScreen()
                                        BottomNavigationItems.PROFILE.route -> mainViewModel.navigateToProfileScreen()
                                    }
                                }
                            )
                        }
                    }
                }
            }
        ) { innerPadding ->
            NavigationHost(
                modifier = Modifier.padding(innerPadding),
                startDestination = Destination.MainScreen.fullRoute,
                navigationChannel = mainViewModel.navigationChannel,
                composableModels = listOf(
                    ComposableModel(destination = Destination.MainScreen.fullRoute) { MainScreen() },
                    ComposableModel(destination = Destination.SearchScreen.fullRoute) { SearchScreen() },
                    ComposableModel(destination = Destination.FavoriteScreen.fullRoute) { FavoriteScreen() },
                    ComposableModel(destination = Destination.ProfileScreen.fullRoute) { ProfileScreen() }
                )
            )
        }
    }
}