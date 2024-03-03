package com.pisakov.favorite

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FavoriteScreen() {
    FavoriteScreen(viewModel())
}

@Composable
internal fun FavoriteScreen(favoriteViewModel: FavoriteViewModel) {
    Text(text = "FavoriteScreen")
}