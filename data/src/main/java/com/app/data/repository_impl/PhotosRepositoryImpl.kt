package com.app.data.repository_impl

import com.app.data.remote_data_source.data_source_api.PhotosRemoteApiDataSource
import com.app.domain.models.interestingness.response.Photos
import com.app.domain.repository_api.PhotosRepository
import io.reactivex.Single
import javax.inject.Inject

class PhotosRepositoryImpl @Inject constructor(private val photosRemoteApiDataSource: PhotosRemoteApiDataSource) :
    PhotosRepository {
    override fun photosSearch(query: String): Single<Photos> {
        return photosRemoteApiDataSource.photosSearch(query = query)
    }
}
