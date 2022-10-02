package com.app.domain.use_case_impl.galleries

import com.app.domain.models.galleries.response.Photos
import com.app.domain.repository_api.GalleriesRepository
import com.app.domain.use_case_api.galleries.GetPhotoListUseCase
import javax.inject.Inject

class GetPhotoListUseCaseImpl @Inject constructor(val galleriesRepository: GalleriesRepository) :
    GetPhotoListUseCase {
    override suspend fun invoke(): Photos {
        return galleriesRepository.getPhotoList()
    }
}
