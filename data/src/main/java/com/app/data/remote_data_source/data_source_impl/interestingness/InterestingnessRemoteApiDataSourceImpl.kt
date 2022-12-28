package com.app.data.remote_data_source.data_source_impl.interestingness

import com.app.data.remote_data_source.data_source_api.InterestingnessRemoteApiDataSource
import com.app.domain.models.common.PhotoListFilter
import com.app.domain.models.interestingness.response.Photos
import io.reactivex.Single
import javax.inject.Inject

class InterestingnessRemoteApiDataSourceImp @Inject constructor(
    val interestingnessApiService: InterestingnessApiService,
    val interestingnessMapper: InterestingnessMapper
) : InterestingnessRemoteApiDataSource {

    override fun getPhotoList(photoListFilter: PhotoListFilter): Single<Photos> {
        val response = with(photoListFilter) {
            interestingnessApiService.getInterestingnessPhotos(
                page = page,
                perPage = perPage,
                date = date,
                oauthNonce = oauthNonce,
                oauthSignature = oauthSignature,
                oauthTimestamp = oauthTimestamp,
                oauthToken = oauthToken
            )
        }
        return response.map { interestingnessMapper.toPhotos(it.photos) }
    }
}
