package com.tiptop.androidbase.ui

import io.reactivex.disposables.CompositeDisposable


interface RootViewModel {
    val disposables: CompositeDisposable
}