package com.app.flickr.di

import com.app.data.di.DataModule
import com.app.domain.di.DomainModule
import dagger.Module

@Module(includes = [DataModule::class, DomainModule::class])
object AppModule

// TODO: 1)remove lateinit 2)remove excess dependencies from app module
