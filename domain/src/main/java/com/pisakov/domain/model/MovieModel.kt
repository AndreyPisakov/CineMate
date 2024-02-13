package com.pisakov.domain.model

data class MovieModel(
    val id: Int,
    val tmdbId: Int?,
    val name: String,
    val type: MovieType,
    val genres: List<Genre>,
    val shortDescription: String,
    val description: String,
    val posterUrl: String?,
    val year: Int?,
    val rating: RatingModel?,
    val movieLength: Int?,
    val videos: VideosModel,
    val top250: Int?
)

enum class MovieType(name: String) {
    MOVIE("movie"),
    TV_SERIES("tv-series"),
    CARTOON("cartoon"),
    ANIMATED_SERIES("animated-series"),
    ANIME("anime")
}

enum class Genre(name: String) {
    DETEKTIV("детектив"),
    VOENNYY("военный"),
    VESTERN("вестерн"),
    BOEVIC("боевик"),
    BIOGRAFIYA("биография"),
    ANIME("аниме"),
    DETSKIY("детский"),
    DLYA_VZROSLYH("для взрослых"),
    DOKUMENTALNYY("документальный"),
    DRAMA("драма"),
    IGRA("игра"),
    ISTORIYA("история"),
    KOMEDIYA("комедия"),
    KONCERT("концерт"),
    KOROTKOMETRAZHKA("короткометражка"),
    KRIMINAL("криминал"),
    MELODRAMA("мелодрама"),
    MUZYKA("музыка"),
    MULTFILM("мультфильм"),
    MYUZIKL("мюзикл"),
    NOVOSTI("новости"),
    PRIKLYUCHENIYA("приключения"),
    REALNOE_TV("реальное ТВ"),
    SEMEYNYY("семейный"),
    SPORT("спорт"),
    TOK_SHOU("ток-шоу"),
    TRILLER("триллер"),
    UZHASY("ужасы"),
    FANTASTIKA("фантастика"),
    FILM_NUAR("фильм-нуар"),
    FENTEZI("фэнтези"),
    CEREMONIYA("церемония")
}

data class RatingModel(
    val kpHD: Float?,
    val imdb: Float?,
    val tmdb: Float?,
    val filmCritics: Float?,
    val russianFilmCritics: Float?,
    val await: Float?
)

data class VideosModel(
    val teasers: List<VideoModel>,
    val trailers: List<VideoModel>
)

data class VideoModel(
    val url: String?,
    val name: String
)