package com.app.flickr.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.data.remote_data_source.data_source_impl.interestingness.base.Result
import com.app.data.remote_data_source.utils.asResult
import com.app.data.remote_data_source.utils.replayRefcount
import com.app.domain.models.interestingness.response.Photos
import com.app.domain.use_case_api.interestingness.SearchPhotoUseCase
import com.app.flickr.presentation.search.mapper.PhotoSearchUIMapper
import com.app.flickr.presentation.search.model.FoundPhotosList
import com.app.flickr.utils.const.EMPTY_STRING
import io.reactivex.BackpressureStrategy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.cast
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class PhotoSearchViewModel @Inject constructor(
    val searchPhotoUseCase: SearchPhotoUseCase,
    val photosSearchUIMapper: PhotoSearchUIMapper
) : ViewModel() {

    private val photosMutableLiveData =
        MutableLiveData<Result<FoundPhotosList>>()
    val photosLiveData: LiveData<Result<FoundPhotosList>>
        get() = photosMutableLiveData

    val compositeDisposable = CompositeDisposable()

    private val querySubject: BehaviorSubject<String> = BehaviorSubject.createDefault(EMPTY_STRING)

    init {
        val queryFlowable = querySubject.toFlowable(BackpressureStrategy.DROP)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .filter { it.isNotEmpty() }
            .switchMap {
                searchPhotoUseCase.invoke(it)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .asResult()
            }
            .replayRefcount()

        val querySuccess = queryFlowable.filter { it is Result.Success }
            .cast<Result.Success<Photos>>()
            .replayRefcount()

        val queryError = queryFlowable.filter { it is Result.Error }
            .cast<Result.Error>()
            .replayRefcount()

        val queryLoading = queryFlowable.filter { it is Result.Loading }
            .cast<Result.Loading>()
            .replayRefcount()

        compositeDisposable.add(
            querySuccess
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    val photosDataUIList = it.result.photo.map(photosSearchUIMapper::toPhotoDataUI)
                    photosMutableLiveData.postValue(Result.Success(FoundPhotosList(photosDataUIList)))
                }
        )

        compositeDisposable.add(
            queryError
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { photosMutableLiveData.postValue(it) }
        )

        compositeDisposable.add(
            queryLoading
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { photosMutableLiveData.postValue(it) }
        )
    }

    fun searchPhoto(query: String) {
        querySubject.onNext(query)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
