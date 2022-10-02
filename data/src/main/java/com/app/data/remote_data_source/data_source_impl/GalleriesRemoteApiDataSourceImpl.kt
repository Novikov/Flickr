package com.app.data.remote_data_source.data_source_impl

import com.app.data.remote_data_source.api_service.galleries.GalleriesApiService
import com.app.data.remote_data_source.api_service.galleries.GalleriesMapper
import com.app.data.remote_data_source.data_source_api.GalleriesRemoteApiDataSource
import com.app.domain.models.galleries.response.Photos
import javax.inject.Inject

class GalleriesRemoteApiDataSourceImp @Inject constructor(
    val galleryApiService: GalleriesApiService,
    val galleriesMapper: GalleriesMapper
) : GalleriesRemoteApiDataSource {
    override suspend fun getPhotoList(): Photos {
        val response = galleryApiService.getInterestingnessPhotos()
        return galleriesMapper.toPhotos(response)
    }
}
