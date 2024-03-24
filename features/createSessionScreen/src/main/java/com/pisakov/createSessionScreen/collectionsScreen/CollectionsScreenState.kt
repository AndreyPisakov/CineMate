package com.pisakov.createSessionScreen.collectionsScreen

import com.pisakov.domain.model.MovieCollectionsModel

sealed interface CollectionsScreenState {

    object Loading : CollectionsScreenState

    class Success(val collections: List<MovieCollectionsModel>) : CollectionsScreenState

    object Failed : CollectionsScreenState
}