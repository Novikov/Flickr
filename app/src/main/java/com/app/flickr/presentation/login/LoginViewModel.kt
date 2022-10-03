package com.app.flickr.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.domain.use_case_api.interestingness.GetMostInterestingPhotosUseCase
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val getPhotoListUseCase: GetMostInterestingPhotosUseCase) :
    ViewModel() {

    @Suppress("UNCHECKED_CAST")
    class Factory(private val getMostInterestingPhotosUseCase: GetMostInterestingPhotosUseCase) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LoginViewModel(getMostInterestingPhotosUseCase) as T
        }

        class NestedFactory @Inject constructor(val getMostInterestingPhotosUseCase: GetMostInterestingPhotosUseCase) {
            fun create(): LoginViewModel.Factory {
                return LoginViewModel.Factory(getMostInterestingPhotosUseCase)
            }
        }
    }
}
