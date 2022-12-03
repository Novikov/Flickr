package com.app.flickr.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.flickr.presentation.detail.di.DetailViewModelAssistedFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

class DetailViewModel @AssistedInject constructor(@Assisted private val photoId: String) :
    ViewModel() {

    class Factory(
        private val assistedFactory: DetailViewModelAssistedFactory,
        private val photoId: String
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return assistedFactory.create(photoId) as T
        }
    }
}
