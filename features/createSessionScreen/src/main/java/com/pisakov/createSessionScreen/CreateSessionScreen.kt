package com.pisakov.createSessionScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.pisakov.createSessionScreen.collectionsScreen.CollectionsScreen
import com.pisakov.createSessionScreen.collectionsScreen.CollectionsScreenViewModel
import com.pisakov.createSessionScreen.filtersScreen.FiltersScreen
import com.pisakov.createSessionScreen.filtersScreen.FiltersScreenViewModel
import com.pisakov.domain.model.MovieModel

@Composable
fun CreateSessionScreen(
    createSessionScreenViewModel: CreateSessionScreenViewModel,
    filtersScreenViewModel: FiltersScreenViewModel,
    collectionsScreenViewModel: CollectionsScreenViewModel
) {
    var tabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("Фильтры", "Коллекции")
    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(text = { Text(title) },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index }
                )
            }
        }
        when (tabIndex) {
            0 -> FiltersScreen(
                viewModel = filtersScreenViewModel,
                createSession = { movies: List<MovieModel> -> createSessionScreenViewModel.createSession(movies) }
            )
            1 -> CollectionsScreen(
                viewModel = collectionsScreenViewModel,
                createSession = { movies: List<MovieModel> -> createSessionScreenViewModel.createSession(movies) }
            )
        }
    }
}

