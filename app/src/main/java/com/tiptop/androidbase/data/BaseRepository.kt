package com.tiptop.androidbase.data

import io.reactivex.disposables.CompositeDisposable


abstract class BaseRepository {

    // This is used to capture all the disposables needed by repository implementations
    protected val disposables = CompositeDisposable()
}