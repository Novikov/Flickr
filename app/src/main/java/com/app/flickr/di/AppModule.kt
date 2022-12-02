package com.app.flickr.di

import com.app.data.di.DataModule
import com.app.domain.di.DomainModule
import com.app.flickr.presentation.di.PresentationModule
import dagger.Module

@Module(includes = [DataModule::class, DomainModule::class, PresentationModule::class])
object AppModule

// TODO: 1)remove lateinit 2)remove excess dependencies from app module
