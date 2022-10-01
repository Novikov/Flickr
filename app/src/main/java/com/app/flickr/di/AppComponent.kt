package com.app.flickr.di

import com.app.flickr.presentation.login.LoginFragment
import dagger.Component

@Component
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }

    fun inject(loginFragment: LoginFragment)
}
