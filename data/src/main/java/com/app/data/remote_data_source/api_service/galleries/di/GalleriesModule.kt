package com.app.data.remote_data_source.api_service.galleries.di

import com.app.data.remote_data_source.api_service.galleries.GalleriesApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object GalleriesModule {
    @Provides
    fun provideGalleryApiService(retrofit: Retrofit): GalleriesApiService {
        return retrofit.create(GalleriesApiService::class.java)
    }
}
