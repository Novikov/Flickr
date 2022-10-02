package com.app.data.remote_data_source.data_source_impl.di

import com.app.data.local_data_source.local_data_source_api.FlickrLocalApiDataSource
import com.app.data.local_data_source.local_data_source_impl.FlickrLocalApiDataSourceImpl
import com.app.data.remote_data_source.api_service.galleries.di.GalleriesModule
import com.app.data.remote_data_source.data_source_api.GalleriesRemoteApiDataSource
import com.app.data.remote_data_source.data_source_impl.GalleriesRemoteApiDataSourceImp
import dagger.Binds
import dagger.Module

@Module(includes = [GalleriesModule::class])
interface RemoteDataSourceModule {
    @Binds
    fun bindFlickrLocalApiDataSourceImpl_to_FlickrLocalApiDataSource(flickrLocalApiDataSourceImpl: FlickrLocalApiDataSourceImpl): FlickrLocalApiDataSource

    @Binds
    fun bindFlickrRemoteApiDataSourceImpl_to_FlickrRemoteApiDataSource(flickrRemoteApiDataSourceImp: GalleriesRemoteApiDataSourceImp): GalleriesRemoteApiDataSource
}
