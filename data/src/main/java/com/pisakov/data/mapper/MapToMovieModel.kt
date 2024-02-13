package com.pisakov.data.mapper

import com.pisakov.data.model.KinopoiskGenreDto
import com.pisakov.data.model.KinopoiskMovieDto
import com.pisakov.data.model.KinopoiskRatingDto
import com.pisakov.data.model.KinopoiskVideoDto
import com.pisakov.data.model.KinopoiskVideosTypeDto
import com.pisakov.domain.model.Genre
import com.pisakov.domain.model.MovieModel
import com.pisakov.domain.model.MovieType
import com.pisakov.domain.model.RatingModel
import com.pisakov.domain.model.VideoModel
import com.pisakov.domain.model.VideosModel

internal fun mapToMovieModel(movie: KinopoiskMovieDto) = MovieModel(
    id = movie.id,
    tmdbId = movie.externalId.tmdb,
    name = movie.name.orEmpty(),
    type = mapToMovieType(movie.type),
    genres = movie.genres.map(::mapToMovieGenre),
    shortDescription = movie.shortDescription.orEmpty(),
    description = movie.description.orEmpty(),
    posterUrl = movie.poster?.url,
    year = movie.year,
    rating = mapToRatingModel(movie.rating),
    movieLength = movie.movieLength,
    videos = mapToVideosModel(movie.videos),
    top250 = movie.top250
)

private fun mapToMovieType(type: String): MovieType {
    return MovieType.values().first { it.name == type }
}

private fun mapToMovieGenre(genre: KinopoiskGenreDto): Genre {
    return Genre.values().first { it.name == genre.name }
}

private fun mapToRatingModel(rating: KinopoiskRatingDto?): RatingModel? {
    if (rating == null) return null
    return RatingModel(
        kpHD = rating.kpHD,
        imdb = rating.imdb,
        tmdb = rating.tmdb,
        filmCritics = rating.filmCritics,
        russianFilmCritics = rating.russianFilmCritics,
        await = rating.await,
    )
}

private fun mapToVideosModel(videos: KinopoiskVideosTypeDto): VideosModel {
    return VideosModel(
        teasers = videos.teasers.map(::mapToVideoModel),
        trailers = videos.trailers?.map(::mapToVideoModel) ?: listOf(),
    )
}

private fun mapToVideoModel(kinopoiskVideoDto: KinopoiskVideoDto): VideoModel {
    return VideoModel(
        url = kinopoiskVideoDto.url,
        name = kinopoiskVideoDto.name.orEmpty()
    )
}
