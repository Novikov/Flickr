package com.app.data.repository_impl

import com.app.data.local_data_source.FlickrLocalApiDataSource
import com.app.data.remote_data_source.FlickrRemoteApiDataSource
import com.app.domain.models.galleries.response.Photos
import com.app.domain.repository.FlickrRepository
import javax.inject.Inject

class FlickrRepositoryImpl @Inject constructor(
    private val flickrRemoteApiDataSource: FlickrRemoteApiDataSource,
    private val flickrLocalApiDataSource: FlickrLocalApiDataSource
) : FlickrRepository {

    override suspend fun getPhotoList(): Photos {
        return flickrRemoteApiDataSource.getPhotoList()
    }
}
