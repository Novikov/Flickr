package com.app.domain.di

import com.app.domain.use_case_api.galleries.GetPhotoListUseCase
import com.app.domain.use_case_impl.galleries.GetPhotoListUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface UseCaseModule {
    @Binds
    fun bindGetPhotoListUseCaseImpl_to_GetPhotoListUseCase(getPhotoListUseCaseImpl: GetPhotoListUseCaseImpl): GetPhotoListUseCase
}
