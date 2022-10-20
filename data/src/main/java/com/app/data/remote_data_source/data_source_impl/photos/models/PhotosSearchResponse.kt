package com.app.data.remote_data_source.data_source_impl.photos.models

import com.app.data.remote_data_source.data_source_impl.interestingness.models.PhotosResponse

data class PhotosSearchResponse(
    val photos: PhotosResponse,
    val stat: String
)
