package com.app.domain.use_case_impl.interestingness

import com.app.domain.models.common.PhotoListFilter
import com.app.domain.models.interestingness.response.Photos
import com.app.domain.repository_api.InterestingnessRepository
import com.app.domain.use_case_api.interestingness.GetMostInterestingPhotosUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetMostInterestingPhotosUseCaseImpl @Inject constructor(val interestingnessRepository: InterestingnessRepository) :
    GetMostInterestingPhotosUseCase {
    override fun invoke(photoListFilter: PhotoListFilter): Single<Photos> {
        return interestingnessRepository.getPhotoList(photoListFilter)
    }
}
