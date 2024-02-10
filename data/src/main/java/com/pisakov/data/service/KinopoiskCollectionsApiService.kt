package com.pisakov.data.service

import com.pisakov.data.models.KinopoiskCollectionsDto
import retrofit2.http.GET
import retrofit2.http.Query

internal interface KinopoiskCollectionsApiService {

    @GET("/v1.4/movie/list")
    suspend fun getMovieCollections(
        @Query("page") page: Int,
        @Query("limit") limit: Int = 500
    ) : KinopoiskCollectionsDto
}