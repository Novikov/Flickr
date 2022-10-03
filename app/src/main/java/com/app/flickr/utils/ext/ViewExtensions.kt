package com.app.flickr.utils.ext

import android.view.View

inline fun View.onClick(crossinline listener: (View) -> Unit) =
    setOnClickListener { view -> listener(view) }
