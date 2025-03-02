package com.example.restaurantreview.core.data.source.remote

import com.example.restaurantreview.core.data.source.remote.network.ApiService

class RemoteDataSource(private val api:ApiService) {
    suspend fun remoteGetEventByActive(active:Int,q:String?)=api.getEventByActive(active,q)
    suspend fun remoteGetEventByID(id:Int)=api.getEventByID(id)

}