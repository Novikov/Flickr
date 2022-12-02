package com.app.flickr.presentation.home.di

import androidx.lifecycle.ViewModel
import com.app.flickr.presentation.di.ViewModelKey
import com.app.flickr.presentation.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface HomeModule {
    @Binds
    @[IntoMap ViewModelKey(HomeViewModel::class)]
    fun provideHomeViewModel(homeViewModel: HomeViewModel): ViewModel
}
