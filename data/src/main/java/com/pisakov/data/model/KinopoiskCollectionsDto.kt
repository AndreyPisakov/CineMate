package com.pisakov.data.model

import com.google.gson.annotations.SerializedName

internal data class KinopoiskCollectionsDto(
    @SerializedName("docs") val collections: List<KinopoiskCollectionDto>
)

internal data class KinopoiskCollectionDto(
    @SerializedName("slug") val slug: String?,
    @SerializedName("name") val name: String,
    @SerializedName("cover") val image: KinopoiskImageDto?,
    @SerializedName("moviesCount") val moviesCount: Int?
)