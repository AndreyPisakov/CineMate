package com.pisakov.search

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SearchScreen() {
    SearchScreen(viewModel())
}

@Composable
internal fun SearchScreen(searchViewModel: SearchViewModel) {
    Text(text = "SearchScreen")
}