package com.pisakov.mainScreen.mainScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen(viewModel: MainScreenViewModel) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            MainScreenButton(text = "Создать сессию") {
                viewModel.navigateToCreateSessionScreen()
            }
            Spacer(modifier = Modifier.height(20.dp))
            MainScreenButton(text = "Присоединиться к сессии") {
                viewModel.navigateToJoinToSessionScreen()
            }
        }
    }
}

@Composable
private fun MainScreenButton(text: String, onClick: () -> Unit) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = { onClick() }
    ) {
        Text(
            text = text,
            fontSize = 24.sp
        )
    }
}