package com.app.flickr.presentation.di

import com.app.flickr.presentation.home.di.HomeModule
import com.app.flickr.presentation.login.di.LoginModule
import com.app.flickr.presentation.search.di.PhotoSearchModule
import dagger.Module

@Module(includes = [HomeModule::class, LoginModule::class, PhotoSearchModule::class])
interface PresentationModule

// TODO: Think is need separate viewmodules module or make all binds in single module
