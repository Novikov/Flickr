package com.app.domain.models.interestingness.response

data class Photo(
    val id: String,
    val owner: String,
    val title: String,
    val secret: String,
    val server: String
)
