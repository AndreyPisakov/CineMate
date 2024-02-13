package com.pisakov.data.service

import com.pisakov.data.model.KinopoiskCollectionsDto
import retrofit2.http.GET
import retrofit2.http.Query

internal interface KinopoiskCollectionsApiService {

    @GET("/v1.4/movie/list")
    suspend fun getMovieCollections(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 500
    ): KinopoiskCollectionsDto
}