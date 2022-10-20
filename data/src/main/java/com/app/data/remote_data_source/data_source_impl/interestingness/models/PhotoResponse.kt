package com.app.data.remote_data_source.data_source_impl.interestingness.models

data class PhotoResponse(
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: Long,
    val title: String,
    val ispublic: Long,
    val isfriend: Long,
    val isfamily: Long
)
