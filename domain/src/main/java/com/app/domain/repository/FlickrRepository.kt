package com.app.domain.repository

import com.app.domain.models.galleries.response.Photos

interface FlickrRepository {
    suspend fun getPhotoList(): Photos
}
