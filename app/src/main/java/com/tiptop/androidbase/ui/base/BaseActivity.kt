package com.tiptop.androidbase.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


abstract class BaseActivity:
        DaggerAppCompatActivity() {

    val disposables = CompositeDisposable()

    @LayoutRes
    abstract fun getLayoutRes(): Int

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    open fun bindViewModel() {
        disposables.addAll(

        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
    }

    override fun onResume() {
        super.onResume()
        bindViewModel()
    }

    override fun onPause() {
        super.onPause()
        disposables.clear()
    }
}