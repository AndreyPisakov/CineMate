package com.pisakov.cinemate.mainScreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.pisakov.cinemate.navigation.Destination

enum class BottomNavigationItems(val title: String, val icon: ImageVector, val route: String) {
    MAIN(title = "Главная", icon = Icons.Default.Home, route = Destination.MainScreen()),
    SEARCH(title = "Поиск", icon = Icons.Default.Search, route = Destination.SearchScreen()),
    FAVORITE(title = "Избранное", icon = Icons.Default.Favorite, route = Destination.FavoriteScreen()),
    PROFILE(title = "Профиль", icon = Icons.Default.Person, route = Destination.ProfileScreen())
}