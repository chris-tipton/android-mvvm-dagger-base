package com.tiptop.androidbase.ui.base

import androidx.lifecycle.ViewModel
import com.tiptop.androidbase.ui.RootViewModel
import io.reactivex.disposables.CompositeDisposable


abstract class BaseViewModel: RootViewModel, ViewModel() {

    final override val disposables = CompositeDisposable()

    override fun onCleared() {
        disposables.clear()
    }
}