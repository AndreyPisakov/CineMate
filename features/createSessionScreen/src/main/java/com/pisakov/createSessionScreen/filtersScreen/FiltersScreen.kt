package com.pisakov.createSessionScreen.filtersScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.pisakov.domain.model.MovieModel

@Composable
internal fun FiltersScreen(
    viewModel: FiltersScreenViewModel,
    createSession: (movies: List<MovieModel>) -> Unit
) {
    Text(text = "FiltersScreen")
}