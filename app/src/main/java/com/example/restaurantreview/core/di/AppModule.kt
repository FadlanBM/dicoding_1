package com.example.restaurantreview.core.di

import com.example.restaurantreview.core.data.source.remote.RemoteDataSource
import com.example.restaurantreview.core.data.source.remote.network.AppConfig
import org.koin.dsl.module

val module= module {
    single { AppConfig.provideApiService }
    single { RemoteDataSource(get()) }

}