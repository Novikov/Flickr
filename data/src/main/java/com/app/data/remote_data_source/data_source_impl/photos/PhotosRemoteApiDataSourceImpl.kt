package com.app.data.remote_data_source.data_source_impl.photos

import com.app.data.remote_data_source.data_source_api.PhotosRemoteApiDataSource
import com.app.data.remote_data_source.data_source_impl.interestingness.InterestingnessMapper
import com.app.domain.models.interestingness.response.Photos
import io.reactivex.Single
import javax.inject.Inject

class PhotosRemoteApiDataSourceImpl @Inject constructor(
    val photosApiService: PhotosApiService,
    val interestingnessMapper: InterestingnessMapper
) : PhotosRemoteApiDataSource {
    override fun photosSearch(query: String): Single<Photos> {
        val response = photosApiService.getPhotoSearch(query = query)
        return response.map { interestingnessMapper.toPhotos(it.photos) }
    }
}
