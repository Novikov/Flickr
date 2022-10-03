package com.app.domain.use_case_api.interestingness

import com.app.domain.models.interestingness.response.Photos

interface GetMostInterestingPhotosUseCase {
    suspend fun invoke(): Photos
}
