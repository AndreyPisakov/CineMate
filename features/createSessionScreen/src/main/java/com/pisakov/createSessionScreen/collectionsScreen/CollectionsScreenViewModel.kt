package com.pisakov.createSessionScreen.collectionsScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pisakov.domain.model.MovieModel
import com.pisakov.domain.usecase.GetMovieCollectionsUseCase
import com.pisakov.domain.usecase.GetMoviesFromCollectionUseCase
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class CollectionsScreenViewModel @Inject constructor(
    private val getMovieCollectionsUseCase: GetMovieCollectionsUseCase,
    private val getMoviesFromCollectionUseCase: GetMoviesFromCollectionUseCase
) : ViewModel() {

    private val _screenState: MutableState<CollectionsScreenState> = mutableStateOf(
        CollectionsScreenState.Loading)
    internal val screenState
        get() = _screenState

    private val selectedCollection: MutableList<String> = mutableListOf()

    init {
        getMovieCollections()
    }

    private fun getMovieCollections() {
        viewModelScope.launch {
            getMovieCollectionsUseCase.invoke()
                .onSuccess {
                    _screenState.value = CollectionsScreenState.Success(it)
                }
                .onFailure {
                    _screenState.value = CollectionsScreenState.Failed
                    Timber.e(it)
                }
        }
    }

    internal fun refresh() {
        getMovieCollections()
    }

    internal fun onUserHasSelected(createSession: (movies: List<MovieModel>) -> Unit) {
        viewModelScope.launch {
            getMoviesFromCollectionUseCase.invoke(selectedCollection)
                .onSuccess {
                    createSession(it)
                }
                .onFailure {
                    TODO()
                }
        }
    }

    internal fun onCollectionItemClick(isSelected: Boolean, slug: String) {
        if (isSelected) {
            selectedCollection.add(slug)
        } else {
            selectedCollection.remove(slug)
        }
    }
}