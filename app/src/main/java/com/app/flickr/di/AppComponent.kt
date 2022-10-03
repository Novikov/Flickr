package com.app.flickr.di

import com.app.flickr.presentation.home.HomeFragment
import com.app.flickr.presentation.login.LoginFragment
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }

    fun inject(loginFragment: LoginFragment)
    fun inject(homeFragment: HomeFragment)
}
