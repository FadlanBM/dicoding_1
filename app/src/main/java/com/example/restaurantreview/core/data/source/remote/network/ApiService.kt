package com.example.restaurantreview.core.data.source.remote.network

import com.example.restaurantreview.core.data.source.remote.response.ResponseDetailEvent
import com.example.restaurantreview.core.data.source.remote.response.ResponseEvent
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/events")
    suspend fun getEventByActive(
        @Query("active") active: Int
    ): Response<ResponseEvent>
    @GET("/events/{id}")
    suspend fun getEventByID(
        @Path("id") id: Int
    ): Response<ResponseDetailEvent>
}