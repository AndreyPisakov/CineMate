package com.pisakov.favorite

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FavoriteScreen(/*favoriteDependencies: FavoriteDependencies*/) {
    //DaggerFavoriteComponent.factory().create(favoriteDependencies)
    FavoriteScreen(viewModel<FavoriteViewModel>())
}

@Composable
internal fun FavoriteScreen(favoriteViewModel: FavoriteViewModel) {
    Text(text = "FavoriteScreen")
}