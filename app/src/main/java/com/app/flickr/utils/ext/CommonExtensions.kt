package com.app.flickr.utils.ext

fun <T> unsafeLazy(initializer: () -> T): Lazy<T> =
    lazy(LazyThreadSafetyMode.NONE, initializer)
