package com.app.flickr.utils.view_helpers

import android.graphics.Rect
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CheckResult
import androidx.annotation.UiThread
import com.app.flickr.presentation.custom_view.OnDispatchTouchEventListener
import com.app.flickr.utils.ext.unsafeLazy

@UiThread
class OutsideTouchHelper private constructor(
    private val targets: List<View>,
    private val outsideConsumer: (View) -> Unit
) : OnDispatchTouchEventListener {

    private val targetDrawingRect: Rect by unsafeLazy { Rect() }

    override fun dispatchTouchEvent(view: View, event: MotionEvent): Boolean {
        if (event.action != MotionEvent.ACTION_DOWN) {
            return false
        }

        if (view is ViewGroup) {
            val isTouchEventInAnyTarget = targets.any { target ->
                target.getDrawingRect(targetDrawingRect)
                view.offsetDescendantRectToMyCoords(target, targetDrawingRect)
                targetDrawingRect.contains(event.x.toInt(), event.y.toInt())
            }

            if (!isTouchEventInAnyTarget) {
                if (!view.isFocusable) {
                    view.isFocusable = true
                }
                if (!view.isFocusableInTouchMode) {
                    view.isFocusableInTouchMode = true
                }
                view.requestFocus()
                outsideConsumer.invoke(view)
            }
        }

        // Let the touch event go forward
        return false
    }

    class Builder(private val targets: List<View>) {

        @CheckResult
        fun whenOutside(outsideConsumer: (View) -> Unit): OutsideTouchHelper =
            OutsideTouchHelper(targets, outsideConsumer)
    }

    companion object {

        @JvmStatic
        fun onView(target: View): Builder = onViews(listOf(target))

        @JvmStatic
        fun onViews(vararg targets: View): Builder = onViews(listOf(*targets))

        @JvmStatic
        fun onViews(targets: List<View>): Builder = Builder(targets)

        @JvmStatic
        fun withoutViews(): Builder = Builder(emptyList())
    }
}
