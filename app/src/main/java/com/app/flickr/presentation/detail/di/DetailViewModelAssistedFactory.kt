package com.app.flickr.presentation.detail.di

import com.app.flickr.presentation.detail.DetailViewModel
import dagger.assisted.AssistedFactory

@AssistedFactory
interface DetailViewModelAssistedFactory {
    fun create(photoId: String): DetailViewModel
}
