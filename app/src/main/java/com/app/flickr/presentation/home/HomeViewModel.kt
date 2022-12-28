package com.app.flickr.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.data.remote_data_source.utils.NetworkConst.NEXT_PAGE_COUNTER
import com.app.domain.models.common.PhotoListFilter
import com.app.domain.models.interestingness.response.Photos
import com.app.domain.use_case_api.interestingness.GetMostInterestingPhotosUseCase
import com.app.flickr.presentation.home.mapper.PhotosUIMapper
import com.app.flickr.presentation.home.model.PhotoDataUI
import com.app.flickr.utils.ext.logErrorIfDebug
import io.reactivex.android.schedulers.AndroidSchedulers
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

    private val compositeDisposable = CompositeDisposable()

    private var photoListFilter = PhotoListFilter()

    fun getMostInterestingPhotoList() {
        if (photoListFilter.isLastPage) return
        compositeDisposable.add(
            getPhotoListUseCase.invoke(photoListFilter)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    updatePhotoList(it)
                }, {
                    logErrorIfDebug(it)
                })
        )
    }

    private fun updatePhotoList(photos: Photos) {
        updateRecyclerData(photos)
        updatePageCounter(photos)
    }

    private fun updateRecyclerData(photos: Photos) {
        val previousVideoList =
            photosMutableLiveData.value.orEmpty()
        val newList = previousVideoList + photos.photo.map(photosUIMapper::toPhotoDataUI)
        photosMutableLiveData.postValue(newList)
    }

    private fun updatePageCounter(photos: Photos) {
        val currentPage = photos.page
        val isLastPage = photos.page == photos.pages
        val nextPage = if (isLastPage) {
            currentPage
        } else {
            currentPage + NEXT_PAGE_COUNTER
        }
        photoListFilter = photoListFilter.copy(page = nextPage, isLastPage = isLastPage)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
