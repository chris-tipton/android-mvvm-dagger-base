package com.google.cloud.next.ui.about

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.tiptop.androidbase.R
import com.tiptop.androidbase.ui.base.BaseFragment
import com.tiptop.androidbase.ui.fragment.SampleFragmentViewModel
import com.tiptop.androidbase.ui.fragment.SampleFragmentViewModelImpl

class SampleFragment: BaseFragment() {

    private lateinit var aboutViewModel: SampleFragmentViewModel

    companion object {
        fun newInstance(): SampleFragment = SampleFragment()
    }

    override fun bindViewModel() {
        disposables.addAll(

        )
    }

    override fun getLayoutRes() = R.layout.fragment_sample

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        aboutViewModel = ViewModelProviders.of(this, viewModelFactory).get(SampleFragmentViewModelImpl::class.java)
    }

}