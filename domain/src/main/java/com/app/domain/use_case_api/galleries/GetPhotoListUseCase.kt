package com.app.domain.use_case_api.galleries

import com.app.domain.models.galleries.response.Photos

interface GetPhotoListUseCase {
    suspend fun invoke(): Photos
}
