package com.app.data.remote_data_source.data_source_impl.di

import com.app.data.local_data_source.local_data_source_api.FlickrLocalApiDataSource
import com.app.data.local_data_source.local_data_source_impl.FlickrLocalApiDataSourceImpl
import com.app.data.remote_data_source.api_service.interestingness.di.InterestingnessModule
import com.app.data.remote_data_source.data_source_api.InterestingnessRemoteApiDataSource
import com.app.data.remote_data_source.data_source_impl.InterestingnessRemoteApiDataSourceImp
import dagger.Binds
import dagger.Module

@Module(includes = [InterestingnessModule::class])
interface RemoteDataSourceModule {
    @Binds
    fun bindFlickrLocalApiDataSourceImpl_to_FlickrLocalApiDataSource(flickrLocalApiDataSourceImpl: FlickrLocalApiDataSourceImpl): FlickrLocalApiDataSource

    @Binds
    fun bindFlickrRemoteApiDataSourceImpl_to_FlickrRemoteApiDataSource(flickrRemoteApiDataSourceImp: InterestingnessRemoteApiDataSourceImp): InterestingnessRemoteApiDataSource
}
