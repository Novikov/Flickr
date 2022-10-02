package com.app.data.remote_data_source.data_source_api

import com.app.domain.models.galleries.response.Photos

interface GalleriesRemoteApiDataSource {
    suspend fun getPhotoList(): Photos
}
