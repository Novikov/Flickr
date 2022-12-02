package com.app.flickr.presentation.search.di

import androidx.lifecycle.ViewModel
import com.app.flickr.presentation.di.ViewModelKey
import com.app.flickr.presentation.search.PhotoSearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface PhotoSearchModule {
    @Binds
    @[IntoMap ViewModelKey(PhotoSearchViewModel::class)]
    fun providePhotoSearchViewModel(photoSearchViewModel: PhotoSearchViewModel): ViewModel
}
