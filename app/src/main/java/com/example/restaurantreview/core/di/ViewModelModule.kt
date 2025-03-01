package com.example.restaurantreview.core.di

import com.example.restaurantreview.MainActivityViewModel
import com.example.restaurantreview.ui.UpComing.UpcomingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule= module {
    viewModel{MainActivityViewModel(get())}
    viewModel {UpcomingViewModel(get())}
}