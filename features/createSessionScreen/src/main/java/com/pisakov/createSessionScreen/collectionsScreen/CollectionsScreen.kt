package com.pisakov.createSessionScreen.collectionsScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.pisakov.domain.model.MovieCollectionsModel
import com.pisakov.domain.model.MovieModel

@Composable
internal fun CollectionsScreen(
    viewModel: CollectionsScreenViewModel,
    createSession: (movies: List<MovieModel>) -> Unit
) {
    val screenState = viewModel.screenState

    when (val state = screenState.value) {
        CollectionsScreenState.Loading -> LoadingContent()
        is CollectionsScreenState.Success -> SuccessContent(
            collections = state.collections,
            onCollectionItemClick = { isSelected: Boolean, slug: String -> viewModel.onCollectionItemClick(isSelected, slug) },
            onUserHasSelected = { viewModel.onUserHasSelected(createSession) }
        )
        CollectionsScreenState.Failed -> FailedContent { viewModel.refresh() }
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
private fun SuccessContent(
    collections: List<MovieCollectionsModel>,
    onCollectionItemClick: (isSelected: Boolean, slug: String) -> Unit,
    onUserHasSelected: () -> Unit
) {
    Box {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(collections) { CollectionItem(
                collectionsModel = it,
                onCollectionItemClick = onCollectionItemClick
            ) }
        }
        Button(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            onClick = { onUserHasSelected() }
        ) {
            Text(text = "Создать сессию")
        }
    }
}

@Composable
private fun CollectionItem(
    collectionsModel: MovieCollectionsModel,
    onCollectionItemClick: (isSelected: Boolean, slug: String) -> Unit
) {
    var isSelected by remember { mutableStateOf(false) }
    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp),
        onClick = {
            isSelected = !isSelected
            onCollectionItemClick(isSelected, collectionsModel.slug)
        },
        border = BorderStroke(1.dp, if (isSelected) Color.Cyan else Color.Gray),
        shape = RoundedCornerShape(10)
    ){
        Image(
            modifier = Modifier
                .width(180.dp)
                .height(180.dp)
                .padding(end = 20.dp),
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current).data(collectionsModel.imageUrl)
                    .apply(block = fun ImageRequest.Builder.() {
                        allowHardware(true)
                    }).build()
            ),
            contentScale = ContentScale.FillWidth,
            contentDescription = null
        )
        Column(modifier = Modifier.align(Alignment.CenterVertically)) {
            Text(
                text = collectionsModel.name,
                color = Color.White
            )
            collectionsModel.moviesCount?.let {
                Text(
                    text = "Количество фильмов: $it",
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
private fun FailedContent(refresh: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        IconButton(onClick = { refresh() }) {
            Icon(imageVector = Icons.Rounded.Refresh, contentDescription = null)
        }
    }
}