package com.pisakov.data.service

import com.pisakov.data.model.KinopoiskMovieDto
import com.pisakov.data.model.KinopoiskMoviesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface KinopoiskMoviesApiService {

    @GET("/v1.4/movie/{id}")
    suspend fun getMovieById(@Path("id") id: Int): KinopoiskMovieDto

    @GET("/v1.4/movie")
    suspend fun getMoviesWithFilters(
        @Query("page") page: Int,
        @Query("limit") limit: Int = 50,
        @Query("type") types: List<String>?,
        @Query("year") years: List<String>?,
        @Query("rating.kp") rating: List<String>?,
        @Query("genres.name") genres: List<String>?
    ): KinopoiskMoviesDto

    @GET("/v1.4/movie")
    suspend fun getMoviesFromCollection(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 500,
        @Query("lists") collections: List<String>
    ): KinopoiskMoviesDto

    @GET("/v1.4/movie/search")
    suspend fun getMoviesBySearchQuery(
        @Query("page") page: Int,
        @Query("limit") limit: Int = 50,
        @Query("query") searchQuery: String
    ): KinopoiskMoviesDto
}