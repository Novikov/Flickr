package com.app.flickr.presentation.login.di

import androidx.lifecycle.ViewModel
import com.app.flickr.presentation.di.ViewModelKey
import com.app.flickr.presentation.login.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface LoginModule {
    @Binds
    @[IntoMap ViewModelKey(LoginViewModel::class)]
    fun provideLoginViewModel(loginViewModel: LoginViewModel): ViewModel
}
