package com.app.flickr.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.domain.use_case_api.galleries.GetPhotoListUseCase
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val getPhotoListUseCase: GetPhotoListUseCase) :
    ViewModel() {

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
