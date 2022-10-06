package com.app.data.repository_impl.di

import com.app.data.repository_impl.InterestingnessRepositoryImpl
import com.app.data.repository_impl.PhotosRepositoryImpl
import com.app.domain.repository_api.InterestingnessRepository
import com.app.domain.repository_api.PhotosRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {
    @Binds
    fun bindInterestingnessRepositoryImpl_to_InterestingnessRepository(interestingnessRepositoryImpl: InterestingnessRepositoryImpl): InterestingnessRepository

    @Binds
    fun bindPhotosRepositoryImpl_to_PhotosRepository(photosRepositoryImpl: PhotosRepositoryImpl): PhotosRepository
}
