package com.pisakov.main_screen.createSessionScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pisakov.domain.usecase.GetMovieCollectionsUseCase
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class CreateSessionScreenViewModel @Inject constructor(
    private val getMovieCollectionsUseCase: GetMovieCollectionsUseCase
) : ViewModel() {

    private val _screenState: MutableState<CreateSessionScreenState> = mutableStateOf(
        CreateSessionScreenState.Loading
    )
    val screenState
        get() = _screenState

    init {
        getMovieCollections()
    }

    private fun getMovieCollections() {
        viewModelScope.launch {
            getMovieCollectionsUseCase.invoke()
                .onSuccess {
                    _screenState.value = CreateSessionScreenState.Success(it)
                }
                .onFailure {
                    _screenState.value = CreateSessionScreenState.Failed
                    Timber.e(it)
                }
        }
    }
}