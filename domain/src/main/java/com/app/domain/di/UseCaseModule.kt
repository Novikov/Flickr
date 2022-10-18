package com.app.domain.di

import com.app.domain.use_case_api.interestingness.GetMostInterestingPhotosUseCase
import com.app.domain.use_case_api.interestingness.SearchPhotoUseCase
import com.app.domain.use_case_impl.interestingness.GetMostInterestingPhotosUseCaseImpl
import com.app.domain.use_case_impl.interestingness.SearchPhotoUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface UseCaseModule {
    @Binds
    fun bindGetPhotoListUseCaseImpl_to_GetPhotoListUseCase(getPhotoListUseCaseImpl: GetMostInterestingPhotosUseCaseImpl): GetMostInterestingPhotosUseCase

    @Binds
    fun bindSearchUseCaseImpl_to_PhotoSearchUseCase(searchPhotoUseCaseImpl: SearchPhotoUseCaseImpl): SearchPhotoUseCase
}
