package com.app.data.remote_data_source.data_source_impl.interestingness.models

data class PhotosResponse(
    val page: Long,
    val pages: Long,
    val perpage: Long,
    val total: Long,
    val photo: List<PhotoResponse>
)
