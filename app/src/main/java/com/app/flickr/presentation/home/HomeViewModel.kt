package com.app.flickr.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.domain.use_case_api.interestingness.GetMostInterestingPhotosUseCase
import com.app.flickr.presentation.home.mapper.PhotosUIMapper
import com.app.flickr.presentation.home.model.PhotoDataUI
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getPhotoListUseCase: GetMostInterestingPhotosUseCase,
    private val photosUIMapper: PhotosUIMapper
) :
    ViewModel() {

    private val photosMutableLiveData = MutableLiveData<List<PhotoDataUI>>()
    val photosLiveData: LiveData<List<PhotoDataUI>>
        get() = photosMutableLiveData

    fun getMostInterestingPhotoList() {
        CompositeDisposable().add(
            getPhotoListUseCase.invoke()
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    val photosDataUIList = it.photo.map(photosUIMapper::toPhotoDataUI)
                    photosMutableLiveData.postValue(photosDataUIList)
                }, {
                    throw (it) // TODO: Igor fix
                })
        )
    }

    @Suppress("UNCHECKED_CAST")
    class Factory(
        private val getPhotoListUseCase: GetMostInterestingPhotosUseCase,
        private val photosUIMapper: PhotosUIMapper
    ) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HomeViewModel(getPhotoListUseCase, photosUIMapper) as T
        }

        class NestedFactory @Inject constructor(
            val getPhotoListUseCase: GetMostInterestingPhotosUseCase,
            val photosUIMapper: PhotosUIMapper
        ) {
            fun create(): HomeViewModel.Factory {
                return HomeViewModel.Factory(getPhotoListUseCase, photosUIMapper)
            }
        }
    }
}
