package com.example.restaurantreview.ui.UpComing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.restaurantreview.core.data.repository.AppRepository

class UpcomingViewModel(private val repo: AppRepository) : ViewModel() {
    fun getEventByActive(active:Int,q:String?)=repo.appGetEventByActive(active,q).asLiveData()
}