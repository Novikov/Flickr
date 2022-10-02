package com.app.data.di

import com.app.data.local_data_source.FlickrLocalApiDataSource
import com.app.data.local_data_source.FlickrLocalApiDataSourceImpl
import com.app.data.remote_data_source.FlickrRemoteApiDataSource
import com.app.data.remote_data_source.FlickrRemoteApiDataSourceImp
import com.app.data.repository_impl.FlickrRepositoryImpl
import com.app.domain.repository.FlickrRepository
import dagger.Binds
import dagger.Module

@Module
interface DataBindsModule {
    @Binds
    fun bindFlickrLocalApiDataSourceImpl_to_FlickrLocalApiDataSource(flickrLocalApiDataSourceImpl: FlickrLocalApiDataSourceImpl): FlickrLocalApiDataSource

    @Binds
    fun bindFlickrRemoteApiDataSourceImpl_to_FlickrRemoteApiDataSource(flickrRemoteApiDataSourceImp: FlickrRemoteApiDataSourceImp): FlickrRemoteApiDataSource

    @Binds
    fun bindFlickrRepositoryImpl_to_FlickrRepository(flickrRepositoryImpl: FlickrRepositoryImpl): FlickrRepository
}
