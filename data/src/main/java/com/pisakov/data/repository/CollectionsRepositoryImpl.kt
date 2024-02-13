package com.pisakov.data.repository

import com.pisakov.data.mapper.mapToMovieCollectionModel
import com.pisakov.data.service.KinopoiskCollectionsApiService
import com.pisakov.domain.model.MovieCollectionsModel
import com.pisakov.domain.repository.CollectionsRepository
import javax.inject.Inject

internal class CollectionsRepositoryImpl @Inject constructor(
    private val apiService: KinopoiskCollectionsApiService
) : CollectionsRepository {
    override suspend fun getMovieCollections(): Result<List<MovieCollectionsModel>> {
        return runCatching {
            apiService.getMovieCollections().collections.map(::mapToMovieCollectionModel)
        }
    }
}