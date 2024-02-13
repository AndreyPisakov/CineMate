package com.pisakov.data.model

import com.google.gson.annotations.SerializedName

internal data class KinopoiskMoviesDto(
    @SerializedName("docs") val movies: List<KinopoiskMovieDto>,
    @SerializedName("page") val page: Int,
    @SerializedName("pages") val totalPages: Int
)

internal data class KinopoiskMovieDto(
    @SerializedName("id") val id: Int,
    @SerializedName("externalId") val externalId: ExternalIdDto,
    @SerializedName("name") val name: String?,
    @SerializedName("type") val type: String,
    @SerializedName("genres") val genres: List<KinopoiskGenreDto>,
    @SerializedName("shortDescription") val shortDescription: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("poster") val poster: KinopoiskImageDto?,
    @SerializedName("year") val year: Int?,
    @SerializedName("rating") val rating: KinopoiskRatingDto?,
    @SerializedName("movieLength") val movieLength: Int?,
    @SerializedName("videos") val videos: KinopoiskVideosTypeDto,
    @SerializedName("top250") val top250: Int?
)

internal data class ExternalIdDto(
    @SerializedName("tmdb") val tmdb: Int?
)

internal data class KinopoiskRatingDto(
    @SerializedName("kp") val kpHD: Float?,
    @SerializedName("imdb") val imdb: Float?,
    @SerializedName("tmdb") val tmdb: Float?,
    @SerializedName("filmCritics") val filmCritics: Float?,
    @SerializedName("russianFilmCritics") val russianFilmCritics: Float?,
    @SerializedName("await") val await: Float?
)
internal data class KinopoiskGenreDto(
    @SerializedName("name") val name: String
)

internal data class KinopoiskImageDto(
    @SerializedName("url") val url: String?
)

internal data class KinopoiskVideosTypeDto(
    @SerializedName("teasers") val teasers: List<KinopoiskVideoDto>,
    @SerializedName("trailers") val trailers: List<KinopoiskVideoDto>?
)

internal data class KinopoiskVideoDto(
    @SerializedName("url") val url: String?,
    @SerializedName("name") val name: String?
)

