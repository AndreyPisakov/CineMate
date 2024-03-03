package com.pisakov.cinemate.mainScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pisakov.cinemate.navigation.NavigationHost
import com.pisakov.cinemate.navigation.SetupNavigation
import com.pisakov.cinemate.ui.theme.CineMateTheme

@Composable
fun MainScreen(mainViewModel: MainViewModel = viewModel()) {
    val navController = rememberNavController()
    SetupNavigation(
        navigationChannel = mainViewModel.navigationChannel,
        navHostController = navController
    )
    CineMateTheme {
        Scaffold(
            bottomBar = {
                BottomNavigation(
                    modifier = Modifier.height(50.dp),
                    backgroundColor = BottomAppBarDefaults.containerColor
                ) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    Row {
                        BottomNavigationItems.values().forEach {
                            BottomNavigationItem(
                                label = { Text(text = it.title, fontSize = 12.sp) },
                                icon = { Icon(it.icon, contentDescription = null) },
                                selected = currentDestination?.hierarchy?.any { navDestination -> navDestination.route == it.route } == true,
                                selectedContentColor = Color.White,
                                unselectedContentColor = Color.Gray,
                                onClick = { mainViewModel.onBottomNavigationClick(it.route) }
                            )
                        }
                    }
                }
            }
        ) { innerPadding ->
            NavigationHost(
                modifier = Modifier.padding(innerPadding),
                navController = navController
            )
        }
    }
}

@Composable
fun HomeScreen() {
    Text(text = "HomeScreen")
}

@Composable
fun UsersScreen() {
    Text(text = "UsersScreen")
}

@Composable
fun UserDetailsScreen() {
    Text(text = "UserDetailsScreen")
}

@Composable
fun MessagesScreen() {
    Text(text = "MessagesScreen")
}