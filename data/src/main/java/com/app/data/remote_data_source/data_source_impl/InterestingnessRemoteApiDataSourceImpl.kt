package com.app.data.remote_data_source.data_source_impl

import com.app.data.remote_data_source.api_service.interestingness.InterestingnessApiService
import com.app.data.remote_data_source.api_service.interestingness.InterestingnessMapper
import com.app.data.remote_data_source.data_source_api.InterestingnessRemoteApiDataSource
import com.app.domain.models.interestingness.response.Photos
import javax.inject.Inject

class InterestingnessRemoteApiDataSourceImp @Inject constructor(
    val interestingnessApiService: InterestingnessApiService,
    val interestingnessMapper: InterestingnessMapper
) : InterestingnessRemoteApiDataSource {
    override suspend fun getPhotoList(): Photos {
        val response = interestingnessApiService.getInterestingnessPhotos()
        return interestingnessMapper.toPhotos(response.photos)
    }
}
