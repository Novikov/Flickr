package com.app.data.remote_data_source.data_source_impl.photos.di

import com.app.data.remote_data_source.data_source_impl.photos.PhotosApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object PhotosModule {
    @Provides
    fun providePhotosApiService(retrofit: Retrofit): PhotosApiService {
        return retrofit.create(PhotosApiService::class.java)
    }
}
