package com.app.data.di

import com.app.data.local_data_source.FlickrLocalApiDataSource
import com.app.data.local_data_source.FlickrLocalApiDataSourceImpl
import com.app.data.remote_data_source.data_source_api.GalleriesRemoteApiDataSource
import com.app.data.remote_data_source.data_source_impl.GalleriesRemoteApiDataSourceImp
import dagger.Binds
import dagger.Module

@Module
interface DataSourceModule {
    @Binds
    fun bindFlickrLocalApiDataSourceImpl_to_FlickrLocalApiDataSource(flickrLocalApiDataSourceImpl: FlickrLocalApiDataSourceImpl): FlickrLocalApiDataSource

    @Binds
    fun bindFlickrRemoteApiDataSourceImpl_to_FlickrRemoteApiDataSource(flickrRemoteApiDataSourceImp: GalleriesRemoteApiDataSourceImp): GalleriesRemoteApiDataSource
}
