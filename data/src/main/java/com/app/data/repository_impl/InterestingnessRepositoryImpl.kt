package com.app.data.repository_impl

import com.app.data.remote_data_source.data_source_api.InterestingnessRemoteApiDataSource
import com.app.domain.models.common.PhotoListFilter
import com.app.domain.models.interestingness.response.Photos
import com.app.domain.repository_api.InterestingnessRepository
import io.reactivex.Single
import javax.inject.Inject

class InterestingnessRepositoryImpl @Inject constructor(private val interestingnessRemoteApiDataSource: InterestingnessRemoteApiDataSource) :
    InterestingnessRepository {

    override fun getPhotoList(photoListFilter: PhotoListFilter): Single<Photos> {
        return interestingnessRemoteApiDataSource.getPhotoList(photoListFilter)
    }
}
