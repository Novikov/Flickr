package com.app.domain.use_case_api.interestingness

import com.app.domain.models.common.PhotoListFilter
import com.app.domain.models.interestingness.response.Photos
import io.reactivex.Single

interface GetMostInterestingPhotosUseCase {
    fun invoke(photoListFilter: PhotoListFilter): Single<Photos>
}
