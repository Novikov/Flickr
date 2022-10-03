package com.app.data.remote_data_source.api_service.galleries.models

import com.squareup.moshi.Json

data class PhotosExtraResponse(
    @Json(name = "explore_date")
    val exploreDate: String,

    @Json(name = "next_prelude_interval")
    val nextPreludeInterval: Long
)
