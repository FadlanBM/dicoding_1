package com.example.restaurantreview.core.di

import com.example.restaurantreview.core.data.repository.AppRepository
import org.koin.dsl.module


val repositoryModule= module{
    single { AppRepository(get()) }
}