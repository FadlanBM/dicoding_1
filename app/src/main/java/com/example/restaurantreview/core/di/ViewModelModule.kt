package com.example.restaurantreview.core.di

import com.example.restaurantreview.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule= module {
    viewModel{MainActivityViewModel(get())}
}