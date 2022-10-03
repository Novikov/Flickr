package com.app.data.repository_impl.di

import com.app.data.repository_impl.InterestingnessRepositoryImpl
import com.app.domain.repository_api.InterestingnessRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {
    @Binds
    fun bindInterestingnessRepositoryImpl_to_InterestingnessRepository(interestingnessRepositoryImpl: InterestingnessRepositoryImpl): InterestingnessRepository
}
