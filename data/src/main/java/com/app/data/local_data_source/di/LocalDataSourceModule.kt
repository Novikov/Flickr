package com.app.data.local_data_source.di

import com.app.data.local_data_source.local_data_source_api.FlickrLocalApiDataSource
import com.app.data.local_data_source.local_data_source_impl.FlickrLocalApiDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
interface LocalDataSourceModule {

    @Binds
    fun flickrLocalApiDataSourceImpl_to_FlickLocalApiDataSource(flickrLocalApiDataSourceImpl: FlickrLocalApiDataSourceImpl): FlickrLocalApiDataSource
}
