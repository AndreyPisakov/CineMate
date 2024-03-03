package com.pisakov.cinemate.containerScreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.pisakov.cinemate.Destination

enum class BottomNavigationItems(val title: String, val icon: ImageVector, val route: String) {
    MAIN(title = "Главная", icon = Icons.Default.Home, route = Destination.MainScreen.route),
    SEARCH(title = "Поиск", icon = Icons.Default.Search, route = Destination.SearchScreen.route),
    FAVORITE(title = "Избранное", icon = Icons.Default.Favorite, route = Destination.FavoriteScreen.route),
    PROFILE(title = "Профиль", icon = Icons.Default.Person, route = Destination.ProfileScreen.route)
}