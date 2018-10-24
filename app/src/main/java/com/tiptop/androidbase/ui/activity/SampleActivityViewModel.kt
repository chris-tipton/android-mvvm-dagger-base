package com.tiptop.androidbase.ui.activity

import com.tiptop.androidbase.data.user.UserData
import com.tiptop.androidbase.data.user.UserRepository
import com.tiptop.androidbase.ext.applyIOSchedulers
import com.tiptop.androidbase.ext.toFlowableLatest
import com.tiptop.androidbase.ui.RootViewModel
import com.tiptop.androidbase.ui.base.BaseViewModel
import io.reactivex.Flowable
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

interface SampleActivityViewModel: RootViewModel {

    /**
     * Do some stuff for SampleActivity
     */
    val user: Flowable<UserData>
}

class SampleActivityViewModelImpl @Inject constructor(
    private val userRepository: UserRepository
): BaseViewModel(), SampleActivityViewModel {

    private val _user = BehaviorSubject.create<UserData>()
    override val user: Flowable<UserData> = _user.toFlowableLatest()

    init {
        userRepository.fetchUserData()
                .applyIOSchedulers()
                .subscribe {
                    _user.onNext(it)
                }.addTo(disposables)
    }
}