package com.app.data.remote_data_source.data_source_api

import com.app.domain.models.interestingness.response.Photos
import io.reactivex.Single

interface InterestingnessRemoteApiDataSource {
    fun getPhotoList(): Single<Photos>
}
