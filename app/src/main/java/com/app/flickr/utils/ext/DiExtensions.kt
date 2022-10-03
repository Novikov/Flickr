package com.app.flickr.utils.ext

import android.content.Context
import com.app.flickr.App
import com.app.flickr.di.AppComponent

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }
