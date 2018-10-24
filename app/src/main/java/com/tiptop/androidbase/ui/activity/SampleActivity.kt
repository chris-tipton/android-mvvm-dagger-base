package com.tiptop.androidbase.ui.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.tiptop.androidbase.ui.base.BaseActivity
import com.tiptop.androidbase.R

class SampleActivity: BaseActivity() {

    private lateinit var primaryViewModel: SampleActivityViewModel

    override fun getLayoutRes() = R.layout.activity_sample

    override fun bindViewModel() {
        super.bindViewModel()
        disposables.addAll(
                // Add VM subscriptions here
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        primaryViewModel = ViewModelProviders.of(this, viewModelFactory).get(SampleActivityViewModelImpl::class.java)
    }
}
