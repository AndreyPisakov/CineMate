package com.pisakov.cinemate.containerScreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.pisakov.navigation.FavoriteScreenDestination
import com.pisakov.navigation.MainScreenDestination
import com.pisakov.navigation.ProfileScreenDestination
import com.pisakov.navigation.SearchScreenDestination

enum class BottomNavigationItems(val title: String, val icon: ImageVector, val route: String) {
    MAIN(title = "Главная", icon = Icons.Default.Home, route = MainScreenDestination.route),
    SEARCH(title = "Поиск", icon = Icons.Default.Search, route = SearchScreenDestination.route),
    FAVORITE(title = "Избранное", icon = Icons.Default.Favorite, route = FavoriteScreenDestination.route),
    PROFILE(title = "Профиль", icon = Icons.Default.Person, route = ProfileScreenDestination.route)
}