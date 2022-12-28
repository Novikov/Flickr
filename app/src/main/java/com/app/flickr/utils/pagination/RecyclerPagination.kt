package com.app.flickr.utils.pagination

import android.util.Log
import androidx.annotation.IntRange
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

object RecyclerPagination {
    private const val ITEM_BEFORE_LOAD_DEFAULT = 3
    private const val CORRECTION_POSITION = 1

    private var scrollListener: RecyclerView.OnScrollListener? = null

    fun scroll(
        recycler: RecyclerView?,
        nextPageLoader: (() -> Unit)?,
        itemBeforeLoad: Int = ITEM_BEFORE_LOAD_DEFAULT
    ) {
        recycler ?: return
        nextPageLoader ?: return
        scrollListener?.let { recycler.removeOnScrollListener(it) }
        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                scrollListener = this

                val adapter = recyclerView.adapter
                val layoutManager = recyclerView.layoutManager
                if (adapter != null && layoutManager != null) {
                    val lastVisibleItemPosition = getLastVisibleItemPosition(layoutManager)

                    val currentIndex = adapter.itemCount - CORRECTION_POSITION
                    val updatePosition =
                        currentIndex - itemBeforeLoad

                    Log.i(
                        "pagination",
                        "onScrolled: lastVisibleItemPosition - $lastVisibleItemPosition, currentIndex - $currentIndex, update position - $updatePosition"
                    )

                    if (lastVisibleItemPosition >= updatePosition) {
                        recyclerView.removeOnScrollListener(this)
                        nextPageLoader()
                    }
                }
            }
        })
    }

    @IntRange(from = RecyclerView.NO_POSITION.toLong())
    private fun getLastVisibleItemPosition(layoutManager: RecyclerView.LayoutManager): Int {
        if (layoutManager is LinearLayoutManager) {
            return layoutManager.findLastVisibleItemPosition()
        }
        throw RuntimeException("Unknown LayoutManager class: ${layoutManager::class.simpleName}")
    }

    fun removeListener() {
        scrollListener = null
    }
}
