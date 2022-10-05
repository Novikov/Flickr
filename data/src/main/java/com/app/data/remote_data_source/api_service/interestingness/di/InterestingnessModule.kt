package com.app.data.remote_data_source.api_service.interestingness.di

import com.app.data.remote_data_source.api_service.interestingness.InterestingnessApiService
import com.app.domain.models.interestingness.response.Photos
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object InterestingnessModule {
    @Provides
    fun provideInterestingnessApiService(retrofit: Retrofit): InterestingnessApiService {
        return retrofit.create(InterestingnessApiService::class.java)
    }

    @Provides
    fun providesPhotos(): Photos? {
        return null
    }
}
