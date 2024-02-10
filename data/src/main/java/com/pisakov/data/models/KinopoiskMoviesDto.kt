package com.pisakov.data.models

import com.google.gson.annotations.SerializedName

internal data class KinopoiskMoviesDto(
    @SerializedName("docs") val movies: List<KinopoiskMovieDto>,
    @SerializedName("page") val page: Int,
    @SerializedName("pages") val totalPages: Int
)

internal data class KinopoiskMovieDto(
    @SerializedName("id") val id: Int,
    @SerializedName("externalId") val externalId: ExternalId,
    @SerializedName("name") val name: String?,
    @SerializedName("type") val type: String,
    @SerializedName("genres") val genres: List<KinopoiskGenre>,
    @SerializedName("shortDescription") val shortDescription: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("poster") val poster: KinopoiskImage?,
    @SerializedName("year") val year: Int?,
    @SerializedName("rating") val rating: KinopoiskRating?,
    @SerializedName("movieLength") val movieLength: Int?,
    @SerializedName("videos") val videos: KinopoiskVideosType,
    @SerializedName("top250") val top250: Int?
)

internal data class ExternalId(
    @SerializedName("kpHD") val kpHD: String?,
    @SerializedName("imdb") val imdb: String?,
    @SerializedName("tmdb") val tmdb: Int?
)

internal data class KinopoiskRating(
    @SerializedName("kp") val kpHD: Float?,
    @SerializedName("imdb") val imdb: Float?,
    @SerializedName("tmdb") val tmdb: Float?,
    @SerializedName("filmCritics") val filmCritics: Float?,
    @SerializedName("russianFilmCritics") val russianFilmCritics: Float?,
    @SerializedName("await") val await: Float?
)

internal data class KinopoiskImage(
    @SerializedName("url") val url: String?
)

internal data class KinopoiskVideosType(
    @SerializedName("teasers") val teasers: List<KinopoiskVideo>,
    @SerializedName("trailers") val trailers: List<KinopoiskVideo>?
)

internal data class KinopoiskVideo(
    @SerializedName("url") val url: String?,
    @SerializedName("name") val name: String?
)

internal data class KinopoiskGenre(
    @SerializedName("name") val name: String?
)
