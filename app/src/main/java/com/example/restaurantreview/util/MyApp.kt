package com.example.restaurantreview.util

import android.app.Application
import com.chibatching.kotpref.Kotpref
import com.example.restaurantreview.core.di.ViewModelModule
import com.example.restaurantreview.core.di.module
import com.example.restaurantreview.core.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp:Application() {
    override fun onCreate() {
        super.onCreate()
        Kotpref.init(this)
        startKoin() {
            androidContext(this@MyApp)
            modules(listOf(module, ViewModelModule, repositoryModule))
        }
    }
}