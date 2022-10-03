package com.app.domain.repository_api

import com.app.domain.models.interestingness.response.Photos

interface InterestingnessRepository {
    suspend fun getPhotoList(): Photos
}
