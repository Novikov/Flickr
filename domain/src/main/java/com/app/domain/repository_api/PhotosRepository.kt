package com.app.domain.repository_api

import com.app.domain.models.interestingness.response.Photos
import io.reactivex.Single

interface PhotosRepository {
    fun photosSearch(query: String): Single<Photos>
}
