package com.app.flickr.presentation.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.app.domain.use_case_api.galleries.GetPhotoListUseCase
import com.app.flickr.utils.logErrorIfDebug
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val getPhotoListUseCase: GetPhotoListUseCase) :
    ViewModel() {

    fun getRequestToken() {
        viewModelScope.launch {
            runCatching {
                getPhotoListUseCase.invoke()
            }.onSuccess {
                Log.i("ASDASDASD", "sucess")
            }
                .onFailure {
                    logErrorIfDebug(it)
                }
        }
    }

    @Suppress("UNCHECKED_CAST")
    class Factory(private val getPhotoListUseCase: GetPhotoListUseCase) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LoginViewModel(getPhotoListUseCase) as T
        }

        class NestedFactory @Inject constructor(val getPhotoListUseCase: GetPhotoListUseCase) {
            fun create(): LoginViewModel.Factory {
                return LoginViewModel.Factory(getPhotoListUseCase)
            }
        }
    }
}
