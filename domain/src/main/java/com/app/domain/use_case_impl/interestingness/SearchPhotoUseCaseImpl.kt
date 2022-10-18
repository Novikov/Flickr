package com.app.domain.use_case_impl.interestingness

import com.app.domain.models.interestingness.response.Photos
import com.app.domain.repository_api.PhotosRepository
import com.app.domain.use_case_api.interestingness.SearchPhotoUseCase
import io.reactivex.Single
import javax.inject.Inject

class SearchPhotoUseCaseImpl @Inject constructor(val photosRepository: PhotosRepository) :
    SearchPhotoUseCase {
    override fun invoke(query: String): Single<Photos> {
        return photosRepository.photosSearch(query = query)
    }
}
