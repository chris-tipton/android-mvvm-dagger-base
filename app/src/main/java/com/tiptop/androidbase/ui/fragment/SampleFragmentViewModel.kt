package com.tiptop.androidbase.ui.fragment

import com.tiptop.androidbase.ui.base.BaseViewModel
import com.tiptop.androidbase.ui.RootViewModel
import javax.inject.Inject

interface SampleFragmentViewModel: RootViewModel {

    /**
     * Do some stuff for SampleFragment
     */
    fun doFragmentStuff()
}

class SampleFragmentViewModelImpl
@Inject constructor(

): BaseViewModel(), SampleFragmentViewModel {

    override fun doFragmentStuff() {
        TODO("not implemented")
    }
}
