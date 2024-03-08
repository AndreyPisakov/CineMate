package com.pisakov.data.mapper

import com.pisakov.data.model.KinopoiskCollectionDto
import com.pisakov.domain.model.MovieCollectionsModel

internal fun mapToMovieCollectionModel(collection: KinopoiskCollectionDto) = MovieCollectionsModel(
    slug = collection.slug,
    name = collection.name,
    imageUrl = collection.image?.url,
    moviesCount = collection.moviesCount
)