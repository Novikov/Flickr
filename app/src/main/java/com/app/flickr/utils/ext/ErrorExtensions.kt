package com.app.flickr.utils.ext

import com.app.data.BuildConfig

fun logErrorIfDebug(throwable: Throwable) {
    if (BuildConfig.DEBUG) {
        throwable.printStackTrace()
    }
}
