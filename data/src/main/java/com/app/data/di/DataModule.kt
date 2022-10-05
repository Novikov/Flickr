package com.app.data.di

import com.app.data.BuildConfig
import com.app.data.local_data_source.di.LocalDataSourceModule
import com.app.data.remote_data_source.data_source_impl.di.RemoteDataSourceModule
import com.app.data.remote_data_source.network_const.Endpoint
import com.app.data.remote_data_source.network_const.Endpoints
import com.app.data.remote_data_source.network_const.NetworkConst
import com.app.data.repository_impl.di.RepositoryModule
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module(includes = [RemoteDataSourceModule::class, LocalDataSourceModule::class, RepositoryModule::class])
object DataModule {
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    }

    @Provides
    fun provideConverterFactory(moshi: Moshi): Converter.Factory {
        return MoshiConverterFactory.create(moshi)
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level =
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        return httpLoggingInterceptor
    }

    @Provides
    fun provideOkHttpProvider(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(NetworkConst.TIMEOUT_TIME_IN_SECOND, TimeUnit.SECONDS)
            .connectTimeout(NetworkConst.TIMEOUT_TIME_IN_SECOND, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    fun provideEndpoint(): Endpoint {
        return Endpoints.DEV
    }

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        jsonConverterFactory: Converter.Factory,
        endpoint: Endpoint
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(endpoint.url.toURL())
            .client(okHttpClient)
            .addConverterFactory(jsonConverterFactory)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .validateEagerly(true)
            .build()
    }
}
