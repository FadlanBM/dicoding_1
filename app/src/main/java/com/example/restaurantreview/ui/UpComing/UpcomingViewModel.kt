package com.example.restaurantreview.ui.UpComing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.restaurantreview.core.data.repository.AppRepository

class UpcomingViewModel(private val repo: AppRepository) : ViewModel() {
    fun getEventByActive(active:Int,q:String?)=repo.appGetEventByActive(active,q).asLiveData()
    private val _state = MutableLiveData<Boolean>(true)
    val state: LiveData<Boolean> get() = _state
    fun startLoading() {
        _state.value = true
    }
    fun stopLoading() {
        _state.value = false
    }
}