package com.app.flickr.presentation.login

import androidx.lifecycle.ViewModel
import com.app.domain.use_case_api.interestingness.GetMostInterestingPhotosUseCase
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val getPhotoListUseCase: GetMostInterestingPhotosUseCase) :
    ViewModel()
