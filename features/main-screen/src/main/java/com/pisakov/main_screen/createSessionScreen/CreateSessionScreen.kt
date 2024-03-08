package com.pisakov.main_screen.createSessionScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.pisakov.domain.model.MovieCollectionsModel

@Composable
fun CreateSessionScreen(createSessionScreenViewModel: CreateSessionScreenViewModel) {
    val screenState = createSessionScreenViewModel.screenState

    when (val state = screenState.value) {
        CreateSessionScreenState.Loading -> LoadingContent()
        is CreateSessionScreenState.Success -> SuccessContent(state.collections)
        CreateSessionScreenState.Failed -> FailedContent()
    }

}

@Composable
private fun LoadingContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun SuccessContent(collections: List<MovieCollectionsModel>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(collections) {
            Text(text = it.name + it.moviesCount)
        }
    }
}

@Composable
private fun FailedContent() {

}

