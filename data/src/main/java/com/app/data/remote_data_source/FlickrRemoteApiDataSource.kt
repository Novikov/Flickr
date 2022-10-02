package com.app.data.remote_data_source

import com.app.domain.models.galleries.response.Photos

interface FlickrRemoteApiDataSource {
    suspend fun getPhotoList(): Photos
}
