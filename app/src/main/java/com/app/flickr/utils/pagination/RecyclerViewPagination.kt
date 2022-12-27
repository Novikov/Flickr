package com.app.flickr.utils.pagination

import androidx.annotation.IntRange
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.domain.models.common.PagedList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

class RecyclerViewPagination<Content>(
    private val nextPageLoader: (nextPage: Int) -> Unit
) {

    companion object {
        private const val ITEM_BEFORE_LOAD_DEFAULT = 4
        private const val CORRECTION_POSITION_FROM_COUNT = 1
        private const val NEXT_PAGE_COUNTER = 1
    }

    private val nextPageFlow = MutableSharedFlow<Int>()
    private val scope = CoroutineScope(Executors.newSingleThreadExecutor().asCoroutineDispatcher())
    var additionalScroll: RecyclerView.OnScrollListener? = null

    fun scroll(
        pages: PagedList<Content>,
        recycler: RecyclerView,
        itemBeforeLoad: Int = ITEM_BEFORE_LOAD_DEFAULT
    ) {
        recycler.clearOnScrollListeners()
        additionalScroll?.let { recycler.addOnScrollListener(it) }
        if (pages.currentPage < pages.totalPages) {
            recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    val adapter = recyclerView.adapter
                    val layoutManager = recyclerView.layoutManager
                    if (adapter != null && layoutManager != null) {
                        val lastVisibleItemPosition = getLastVisibleItemPosition(layoutManager)
                        val updatePosition =
                            adapter.itemCount - CORRECTION_POSITION_FROM_COUNT - itemBeforeLoad
                        if (lastVisibleItemPosition >= updatePosition) {
                            recycler.removeOnScrollListener(this)
                            scope.launch {
                                nextPageFlow.emit(pages.currentPage + NEXT_PAGE_COUNTER)
                            }
                        }
                    }
                }
            })
        }
    }

    init {
        scope.launch {
            nextPageFlow
                .distinctUntilChanged()
                .collect {
                    updatePage(it)
                }
        }
    }

    private fun updatePage(nextPage: Int) {
        nextPageLoader(nextPage)
    }

    @IntRange(from = RecyclerView.NO_POSITION.toLong())
    private fun getLastVisibleItemPosition(layoutManager: RecyclerView.LayoutManager): Int {
        if (layoutManager is LinearLayoutManager) {
            return layoutManager.findLastVisibleItemPosition()
        }
        throw RuntimeException("Unknown LayoutManager class: ${layoutManager::class.simpleName}")
    }
}
