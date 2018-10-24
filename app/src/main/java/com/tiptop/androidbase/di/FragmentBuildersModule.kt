package com.tiptop.androidbase.di

import com.google.cloud.next.ui.about.SampleFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeSampleFragment(): SampleFragment
}