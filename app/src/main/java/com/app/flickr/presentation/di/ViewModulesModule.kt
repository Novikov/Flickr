package com.app.flickr.presentation.di

import androidx.lifecycle.ViewModel
import com.app.flickr.presentation.home.HomeViewModel
import com.app.flickr.presentation.login.LoginViewModel
import com.app.flickr.presentation.search.PhotoSearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface ViewModulesModule {
    @Binds
    @[IntoMap ViewModelKey(LoginViewModel::class)]
    fun provideLoginViewModel(loginViewModel: LoginViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(HomeViewModel::class)]
    fun provideHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(PhotoSearchViewModel::class)]
    fun providePhotoSearchViewModel(photoSearchViewModel: PhotoSearchViewModel): ViewModel
}
