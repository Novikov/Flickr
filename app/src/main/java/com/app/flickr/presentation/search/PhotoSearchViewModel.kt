package com.app.flickr.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.domain.use_case_api.interestingness.SearchPhotoUseCase
import com.app.flickr.presentation.home.model.PhotoDataUI
import com.app.flickr.presentation.search.mapper.PhotoSearchUIMapper
import com.app.flickr.utils.ext.logErrorIfDebug
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PhotoSearchViewModel @Inject constructor(
    val searchPhotoUseCase: SearchPhotoUseCase,
    val photosSearchUIMapper: PhotoSearchUIMapper
) : ViewModel() {

    private val photosMutableLiveData = MutableLiveData<List<PhotoDataUI>>()
    val photosLiveData: LiveData<List<PhotoDataUI>>
        get() = photosMutableLiveData

    val compositeDisposable = CompositeDisposable()

    fun searchPhoto(query: String) {
        compositeDisposable.add(
            searchPhotoUseCase.invoke(query)
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    val photosDataUIList = it.photo.map(photosSearchUIMapper::toPhotoDataUI)
                    photosMutableLiveData.postValue(photosDataUIList)
                }, {
                    logErrorIfDebug(it)
                })
        )
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    @Suppress("UNCHECKED_CAST")
    class Factory(
        private val searchPhotoUseCase: SearchPhotoUseCase,
        private val photosUIMapper: PhotoSearchUIMapper
    ) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return PhotoSearchViewModel(searchPhotoUseCase, photosUIMapper) as T
        }

        class NestedFactory @Inject constructor(
            val searchPhotoUseCase: SearchPhotoUseCase,
            val photosUIMapper: PhotoSearchUIMapper
        ) {
            fun create(): PhotoSearchViewModel.Factory {
                return PhotoSearchViewModel.Factory(searchPhotoUseCase, photosUIMapper)
            }
        }
    }
}
