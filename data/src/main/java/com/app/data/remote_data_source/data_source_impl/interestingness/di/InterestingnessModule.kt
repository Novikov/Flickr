package com.app.data.remote_data_source.data_source_impl.interestingness.di

import com.app.data.remote_data_source.data_source_impl.interestingness.InterestingnessApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object InterestingnessModule {
    @Provides
    fun provideInterestingnessApiService(retrofit: Retrofit): InterestingnessApiService {
        return retrofit.create(InterestingnessApiService::class.java)
    }
}
