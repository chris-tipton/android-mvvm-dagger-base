package com.tiptop.androidbase.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tiptop.androidbase.ui.activity.SampleActivityViewModelImpl
import com.tiptop.androidbase.ui.fragment.SampleFragmentViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SampleActivityViewModelImpl::class)
    abstract fun bindSampleActivityViewModel(sampleActivityViewModel: SampleActivityViewModelImpl): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SampleFragmentViewModelImpl::class)
    abstract fun bindSampleFragmentViewModel(sampleFragmentViewModel: SampleFragmentViewModelImpl): ViewModel
}