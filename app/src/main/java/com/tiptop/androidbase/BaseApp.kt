package com.tiptop.androidbase

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.jakewharton.threetenabp.AndroidThreeTen
import com.tiptop.androidbase.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.reactivex.exceptions.UndeliverableException
import io.reactivex.plugins.RxJavaPlugins
import timber.log.Timber
import java.io.IOException
import java.net.SocketException
import javax.inject.Inject

class BaseApp: DaggerApplication() {

    @Inject lateinit var firestore: FirebaseFirestore
    @Inject lateinit var firestoreSettings: FirebaseFirestoreSettings

    override fun onCreate() {
        super.onCreate()

        firestore.firestoreSettings = firestoreSettings
        Timber.plant(Timber.DebugTree())
        AndroidThreeTen.init(this)
        RxJavaPlugins.setErrorHandler {
            when (it) {
                is UndeliverableException -> {
                    Timber.e(it.cause, "UndeliverableException")
                }
                is IOException, is SocketException -> {
                    // fine, irrelevant network problem or API that throws on cancellation
                    Timber.e(it, "Network Error")
                }
                is InterruptedException -> {
                    // fine, some blocking code was interrupted by a dispose call
                    Timber.e(it, "InterruptedException")
                }
                is NullPointerException, is IllegalArgumentException -> {
                    // that's likely a bug in the application
                    Timber.e(it)
                    Thread.currentThread().uncaughtExceptionHandler
                            .uncaughtException(Thread.currentThread(), it)
                }
                is IllegalStateException -> {
                    // that's a bug in RxJava or in a custom operator
                    Timber.e(it)
                    Thread.currentThread().uncaughtExceptionHandler
                            .uncaughtException(Thread.currentThread(), it)
                }
                else -> {
                    Timber.w(it,"Undeliverable exception received, not sure what to do")
                }
            }
        }
    }

    override fun applicationInjector(): AndroidInjector<BaseApp> =
        DaggerAppComponent.builder().create(this@BaseApp)
}