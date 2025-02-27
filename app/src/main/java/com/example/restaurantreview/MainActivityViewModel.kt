package com.example.restaurantreview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.restaurantreview.core.data.repository.AppRepository

class MainActivityViewModel(private val repo:AppRepository):ViewModel() {
    fun getEventByActive(active:Int,q:String?)=repo.appGetEventByActive(active,q).asLiveData()
    fun getEventByID(id:Int)=repo.appGetEventByID(id).asLiveData()
}