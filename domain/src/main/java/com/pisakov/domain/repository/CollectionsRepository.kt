package com.pisakov.domain.repository

import com.pisakov.domain.model.MovieCollectionsModel

interface CollectionsRepository {

    suspend fun getMovieCollections(): Result<List<MovieCollectionsModel>>
}