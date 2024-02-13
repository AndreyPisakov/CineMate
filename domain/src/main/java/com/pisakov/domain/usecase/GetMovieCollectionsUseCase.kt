package com.pisakov.domain.usecase

import com.pisakov.domain.model.MovieCollectionsModel
import com.pisakov.domain.repository.CollectionsRepository
import javax.inject.Inject

class GetMovieCollectionsUseCase @Inject constructor(
    private val repository: CollectionsRepository
) {

    suspend fun invoke(): Result<List<MovieCollectionsModel>> = repository.getMovieCollections()
}