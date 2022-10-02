package com.app.flickr.utils

import android.view.View

inline fun View.onClick(crossinline listener: (View) -> Unit) =
    setOnClickListener { view -> listener(view) }