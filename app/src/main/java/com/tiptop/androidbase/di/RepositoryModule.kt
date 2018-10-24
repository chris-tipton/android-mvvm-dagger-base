package com.tiptop.androidbase.di

import com.tiptop.androidbase.data.sample.SampleRepository
import com.tiptop.androidbase.data.sample.SampleRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindSampleRepository(sampleRepository: SampleRepositoryImpl): SampleRepository
}