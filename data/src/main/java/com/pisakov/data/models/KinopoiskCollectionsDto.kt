package com.pisakov.data.models

import com.google.gson.annotations.SerializedName

internal data class KinopoiskCollectionsDto(
    @SerializedName("docs") val movies: List<KinopoiskCollectionDto>
)

internal data class KinopoiskCollectionDto(
    @SerializedName("slug") val slug: String,
    @SerializedName("name") val name: String,
    @SerializedName("cover") val image: KinopoiskImage,
    @SerializedName("category") val category: String,
    @SerializedName("moviesCount") val moviesCount: Int,
)