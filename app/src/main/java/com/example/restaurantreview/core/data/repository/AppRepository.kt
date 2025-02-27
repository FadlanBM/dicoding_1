package com.example.restaurantreview.core.data.repository

import android.util.Log
import com.example.restaurantreview.core.data.source.remote.RemoteDataSource
import com.example.restaurantreview.core.data.source.remote.network.Resource
import kotlinx.coroutines.flow.flow

class AppRepository(val remote:RemoteDataSource) {

    fun appGetEventByActive(active:Int,q:String?) = flow {
        emit(Resource.loading(null))
        try {
            remote.remoteGetEventByActive(active,q).let {
                if (it.isSuccessful){
                    val body=it.body()
                    emit(Resource.success(body))
                }else{
                    val errorBody = it.errorBody()?.string() ?: "Tidak ada detail error"
                    val statusCode = it.code()
                    emit(Resource.error("Terjadi kesalahan: $errorBody (Status code: $statusCode)", null))
                    Log.e("ERROR", "Error Http: $errorBody (Code: $statusCode)")
                }
            }
        }catch (e:Exception){
            emit(Resource.error(e.message?:"terjadi Kesalahan",null))
            Log.e("TAG", e.message.toString())
        }
    }

    fun appGetEventByID(id:Int) = flow {
        emit(Resource.loading(null))
        try {
            remote.remoteGetEventByID(id).let {
                if (it.isSuccessful){
                    val body=it.body()
                    emit(Resource.success(body))
                }else{
                    val errorBody = it.errorBody()?.string() ?: "Tidak ada detail error"
                    val statusCode = it.code()
                    emit(Resource.error("Terjadi kesalahan: $errorBody (Status code: $statusCode)", null))
                    Log.e("ERROR", "Error Http: $errorBody (Code: $statusCode)")
                }
            }
        }catch (e:Exception){
            emit(Resource.error(e.message?:"terjadi Kesalahan",null))
            Log.e("TAG", e.message.toString())
        }
    }
}