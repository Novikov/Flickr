package com.app.data.remote_data_source.data_source_impl.interestingness.models

data class PhotosResultResponse(
    val photos: PhotosResponse,
    val extra: PhotosExtraResponse,
    val stat: String
)
