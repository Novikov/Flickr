package com.app.flickr.presentation.custom_view

import android.view.MotionEvent
import android.view.View

interface OnDispatchTouchEventListener {
    fun dispatchTouchEvent(view: View, event: MotionEvent): Boolean
}
