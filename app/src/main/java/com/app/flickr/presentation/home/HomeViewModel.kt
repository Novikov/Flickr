package com.app.flickr.presentation.home

import android.util.Log
import androidx.lifecycle.*
import com.app.domain.use_case_api.galleries.GetPhotoListUseCase
import com.app.flickr.presentation.home.mapper.PhotosUIMapper
import com.app.flickr.presentation.home.model.PhotoDataUI
import com.app.flickr.utils.logErrorIfDebug
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getPhotoListUseCase: GetPhotoListUseCase,
    private val photosUIMapper: PhotosUIMapper
) :
    ViewModel() {

    private val photosMutableLiveData = MutableLiveData<List<PhotoDataUI>>()
    val photosLiveData: LiveData<List<PhotoDataUI>>
        get() = photosMutableLiveData

    fun getInterestingnessPhotoList() {
        viewModelScope.launch {
            runCatching {
                getPhotoListUseCase.invoke()
            }.onSuccess { photos ->
                Log.i("ASDASDSAD", "$photos")
                val photosDataUIList = photos.photo.map(photosUIMapper::toPhotoDataUI)
                photosMutableLiveData.postValue(photosDataUIList)
            }
                .onFailure {
                    logErrorIfDebug(it)
                }
        }
    }

    @Suppress("UNCHECKED_CAST")
    class Factory(
        private val getPhotoListUseCase: GetPhotoListUseCase,
        private val photosUIMapper: PhotosUIMapper
    ) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HomeViewModel(getPhotoListUseCase, photosUIMapper) as T
        }

        class NestedFactory @Inject constructor(
            val getPhotoListUseCase: GetPhotoListUseCase,
            val photosUIMapper: PhotosUIMapper
        ) {
            fun create(): HomeViewModel.Factory {
                return HomeViewModel.Factory(getPhotoListUseCase, photosUIMapper)
            }
        }
    }
}
