package com.app.data.di

import com.app.data.repository_impl.GalleriesRepositoryImpl
import com.app.domain.repository_api.GalleriesRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {
    @Binds
    fun bindGalleriesRepositoryImpl_to_GalleriesRepository(flickrRepositoryImpl: GalleriesRepositoryImpl): GalleriesRepository
}
