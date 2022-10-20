package com.app.flickr.presentation.custom_view

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import com.app.flickr.utils.const.DEFAULT_STYLE_ATTRS

class InterceptableCoordinatorLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = DEFAULT_STYLE_ATTRS
) : CoordinatorLayout(context, attrs, defStyleAttr) {

    private val onDispatchTouchEventListeners: MutableSet<OnDispatchTouchEventListener> =
        LinkedHashSet()

    init {
        isFocusable = true
        isFocusableInTouchMode = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            isFocusedByDefault = true
        }
    }

    override fun onDetachedFromWindow() {
        ViewCompat.setOnApplyWindowInsetsListener(this, null)
        super.onDetachedFromWindow()
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        requestFocus()
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        for (listener in onDispatchTouchEventListeners) {
            if (listener.dispatchTouchEvent(this, event)) {
                return true
            }
        }
        return super.dispatchTouchEvent(event)
    }

    fun addOnDispatchTouchEventListener(listener: OnDispatchTouchEventListener) {
        onDispatchTouchEventListeners.add(listener)
    }

    fun removeOnDispatchTouchEventListener(listener: OnDispatchTouchEventListener) {
        onDispatchTouchEventListeners.remove(listener)
    }
}
