package com.app.data.remote_data_source

import com.app.data.remote_data_source.api_service.galleries.GalleriesApiService
import com.app.data.remote_data_source.mappers.GalleriesMapper
import com.app.domain.models.galleries.response.Photos
import javax.inject.Inject

// TODO: Igor divide remote api data source impl
class FlickrRemoteApiDataSourceImp @Inject constructor(
    val galleryApiService: GalleriesApiService,
    val galleriesMapper: GalleriesMapper
) : FlickrRemoteApiDataSource {
    override suspend fun getPhotoList(): Photos {
        val response = galleryApiService.getInterestingnessPhotos()
        return galleriesMapper.toPhotos(response)
    }
}
