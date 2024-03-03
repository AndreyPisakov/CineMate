package com.pisakov.profile

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProfileScreen() {
    ProfileScreen(viewModel())
}

@Composable
internal fun ProfileScreen(profileViewModel: ProfileViewModel) {
    Text(text = "ProfileScreen")
}