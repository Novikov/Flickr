package com.app.domain.use_case_api.interestingness

import com.app.domain.models.interestingness.response.Photos
import io.reactivex.Single

interface SearchPhotoUseCase {
    fun invoke(query: String): Single<Photos>
}
