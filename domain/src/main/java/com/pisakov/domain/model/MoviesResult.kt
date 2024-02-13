package com.pisakov.domain.model

sealed interface MoviesResult {
    class Success(movies: List<MovieModel>): MoviesResult

    object EmptyResult: MoviesResult

    class Failure(exception: Throwable): MoviesResult
}