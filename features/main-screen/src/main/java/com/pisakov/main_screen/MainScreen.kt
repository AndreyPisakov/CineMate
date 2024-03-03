package com.pisakov.main_screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen() {
    MainScreen(viewModel())
}

@Composable
internal fun MainScreen(mainScreenViewModel: MainScreenViewModel) {
    Text(text = "MainScreen")
}