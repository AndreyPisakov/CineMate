package com.pisakov.domain.model

data class MovieCollectionsModel(
    val slug: String,
    val name: String,
    val imageUrl: String?,
    val category: String,
    val moviesCount: Int
)
