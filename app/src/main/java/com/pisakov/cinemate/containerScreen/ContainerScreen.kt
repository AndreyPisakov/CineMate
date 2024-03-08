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
import com.pisakov.cinemate.di.AllModulesDependencies
import com.pisakov.cinemate.ui.theme.CineMateTheme
import com.pisakov.navigation.bottomNavigationItemIsSelected

@Composable
fun ContainerScreen(
    allModulesDependencies: AllModulesDependencies,
    containerViewModel: ContainerViewModel
) {
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
                                        BottomNavigationItems.MAIN.route -> containerViewModel.navigateToMainScreen()
                                        BottomNavigationItems.SEARCH.route -> containerViewModel.navigateToSearchScreen()
                                        BottomNavigationItems.FAVORITE.route -> containerViewModel.navigateToFavoriteScreen()
                                        BottomNavigationItems.PROFILE.route -> containerViewModel.navigateToProfileScreen()
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
                navigationChannel = containerViewModel.navigationChannel,
                allModulesDependencies = allModulesDependencies
            )
        }
    }
}

