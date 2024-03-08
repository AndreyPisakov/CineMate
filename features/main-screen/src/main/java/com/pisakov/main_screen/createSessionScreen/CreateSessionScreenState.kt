package com.pisakov.main_screen.createSessionScreen

import com.pisakov.domain.model.MovieCollectionsModel

sealed interface CreateSessionScreenState {

    object Loading : CreateSessionScreenState

    class Success(val collections: List<MovieCollectionsModel>) : CreateSessionScreenState

    object Failed : CreateSessionScreenState
}