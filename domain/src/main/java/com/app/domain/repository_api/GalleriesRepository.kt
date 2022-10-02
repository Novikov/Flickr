package com.app.domain.repository_api

import com.app.domain.models.galleries.response.Photos

interface GalleriesRepository {
    suspend fun getPhotoList(): Photos
}
