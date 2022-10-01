package com.app.domain.models.galleries

data class Photos(
    val page: Long,
    val pages: Long,
    val perpage: Long,
    val total: Long,
    val photo: List<Photo>
)
