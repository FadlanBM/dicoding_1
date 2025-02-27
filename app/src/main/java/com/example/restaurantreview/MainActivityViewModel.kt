package com.example.restaurantreview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.restaurantreview.core.data.repository.AppRepository

class MainActivityViewModel(private val repo:AppRepository):ViewModel() {
    fun getEventByActive(active:Int)=repo.appGetEventByActive(active).asLiveData()
    fun getEventByID(id:Int)=repo.appGetEventByActive(id).asLiveData()
}