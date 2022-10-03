package com.app.data.remote_data_source.api_service.interestingness.models

data class PhotosResultResponse(
    val photos: PhotosResponse,
    val extra: PhotosExtraResponse,
    val stat: String
)
