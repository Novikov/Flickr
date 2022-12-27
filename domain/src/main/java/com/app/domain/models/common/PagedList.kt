package com.app.domain.models.common

import com.app.domain.models.common.ModelConst.FIRST_PAGE

data class PagedList<T>(
    val content: List<T> = listOf(),
    val totalElements: Int = 0,
    val totalPages: Int = 0,
    val currentPage: Int = FIRST_PAGE
) {
    operator fun plus(newPage: PagedList<T>) = PagedList(
        content = content + newPage.content,
        currentPage = newPage.currentPage,
        totalElements = totalElements,
        totalPages = totalPages
    )
}
