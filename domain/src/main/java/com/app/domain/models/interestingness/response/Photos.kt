package com.app.domain.models.interestingness.response

data class Photos(
    val page: Long,
    val pages: Long,
    val perpage: Long,
    val total: Long,
    val photo: List<Photo>
)
