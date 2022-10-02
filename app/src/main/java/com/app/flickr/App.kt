package com.app.flickr

import android.app.Application
import com.app.flickr.di.AppComponent
import com.app.flickr.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}