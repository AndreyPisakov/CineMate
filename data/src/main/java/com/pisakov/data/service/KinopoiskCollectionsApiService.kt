package com.pisakov.data.service

import com.pisakov.data.model.KinopoiskCollectionsDto
import retrofit2.http.GET
import retrofit2.http.Query

internal interface KinopoiskCollectionsApiService {

    @GET("/v1.4/list")
    suspend fun getMovieCollections(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 250,
        @Query("selectFields") selectFields: List<String> = listOf("name", "cover", "moviesCount"),
        @Query("notNullFields") notNullFields: List<String> = listOf("name", "moviesCount", "cover.url"),
    ): KinopoiskCollectionsDto
}