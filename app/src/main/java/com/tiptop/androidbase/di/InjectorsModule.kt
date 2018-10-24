package com.tiptop.androidbase.di

import com.tiptop.androidbase.ui.activity.SampleActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class InjectorsModule {

    @ContributesAndroidInjector(modules = [(FragmentBuildersModule::class)])
    abstract fun contributeSampleActivity(): SampleActivity
}
