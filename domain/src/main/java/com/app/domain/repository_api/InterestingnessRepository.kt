package com.app.domain.repository_api

import com.app.domain.models.common.PhotoListFilter
import com.app.domain.models.interestingness.response.Photos
import io.reactivex.Single

interface InterestingnessRepository {
    fun getPhotoList(photoListFilter: PhotoListFilter): Single<Photos>
}
