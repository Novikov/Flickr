package com.app.domain.di

import com.app.domain.use_case_api.interestingness.GetMostInterestingPhotosUseCase
import com.app.domain.use_case_impl.interestingness.GetMostInterestingPhotosUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface UseCaseModule {
    @Binds
    fun bindGetPhotoListUseCaseImpl_to_GetPhotoListUseCase(getPhotoListUseCaseImpl: GetMostInterestingPhotosUseCaseImpl): GetMostInterestingPhotosUseCase
}
