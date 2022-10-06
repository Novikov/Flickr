package com.app.data.remote_data_source.data_source_impl.di

import com.app.data.remote_data_source.data_source_api.InterestingnessRemoteApiDataSource
import com.app.data.remote_data_source.data_source_api.PhotosRemoteApiDataSource
import com.app.data.remote_data_source.data_source_impl.interestingness.InterestingnessRemoteApiDataSourceImp
import com.app.data.remote_data_source.data_source_impl.interestingness.di.InterestingnessModule
import com.app.data.remote_data_source.data_source_impl.photos.PhotosRemoteApiDataSourceImpl
import com.app.data.remote_data_source.data_source_impl.photos.di.PhotosModule
import dagger.Binds
import dagger.Module

@Module(includes = [InterestingnessModule::class, PhotosModule::class])
interface RemoteDataSourceModule {

    @Binds
    fun bindInterestingRemoteApiDataSourceImpl_to_InterestingRemoteApiDataSource(
        interestinggRemoteApiDataSource: InterestingnessRemoteApiDataSourceImp
    ): InterestingnessRemoteApiDataSource

    @Binds
    fun bindPhotosRemoteDataSourceImpl_to_PhotosRemoteDataSource(photosRemoteApiDataSourceImpl: PhotosRemoteApiDataSourceImpl): PhotosRemoteApiDataSource
}
