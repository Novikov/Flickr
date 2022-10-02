package com.app.data.repository_impl

import com.app.data.remote_data_source.data_source_api.GalleriesRemoteApiDataSource
import com.app.domain.models.galleries.response.Photos
import com.app.domain.repository_api.GalleriesRepository
import javax.inject.Inject

class GalleriesRepositoryImpl @Inject constructor(private val galleriesRemoteApiDataSource: GalleriesRemoteApiDataSource) :
    GalleriesRepository {

    override suspend fun getPhotoList(): Photos {
        return galleriesRemoteApiDataSource.getPhotoList()
    }
}
