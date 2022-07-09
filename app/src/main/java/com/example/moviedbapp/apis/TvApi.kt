package com.example.moviedbapp.apis

import com.example.moviedbapp.models.GetTvPopularsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TvApi {
    @GET("tv/top_rated")
    suspend fun getPopularTv(
        @Query("api_key")
        apikey: String):GetTvPopularsResponse
}