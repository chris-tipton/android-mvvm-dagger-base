package com.tiptop.androidbase.ext

import com.tiptop.androidbase.data.common.Result
import com.tiptop.androidbase.data.common.Success
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.SingleEmitter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.Flowables
import io.reactivex.rxkotlin.Singles
import io.reactivex.schedulers.Schedulers


fun <T> Observable<T>.toFlowableLatest(): Flowable<T> {
    return this.toFlowable(io.reactivex.BackpressureStrategy.LATEST)
}

inline fun <T> Flowables.createSafeFlowable(strategy: BackpressureStrategy = BackpressureStrategy.BUFFER, crossinline function: (FlowableEmitter<T>) -> Unit): Flowable<T> {
    return Flowable.create<T>( { emitter ->
        try {
            if (!emitter.isCancelled) {
                function(emitter)
            }
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }, strategy)
}

inline fun <T> Singles.createSafeSingle(crossinline function: (SingleEmitter<T>) -> Unit): Single<T> {
    return Single.create<T> { emitter ->
        try {
            if (!emitter.isDisposed) {
                function(emitter)
            }
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }
}

fun <T> Flowable<T>.applyCommonSchedulers(): Flowable<T> {
    return this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Flowable<T>.applyIOSchedulers(): Flowable<T> {
    return this.subscribeOn(Schedulers.io()).observeOn(Schedulers.computation())
}

fun <T> Single<T>.applyCommonSchedulers(): Single<T> {
    return this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Single<T>.applyIOSchedulers(): Single<T> {
    return this.subscribeOn(Schedulers.io()).observeOn(Schedulers.computation())
}

fun <T> Maybe<T>.applyCommonSchedulers(): Maybe<T> {
    return this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Maybe<T>.applyIOSchedulers(): Maybe<T> {
    return this.subscribeOn(Schedulers.io()).observeOn(Schedulers.computation())
}

fun <T> Flowable<Result<T>>.successOnly(): Flowable<Success<T>> {
    return this.filter { it is Success }
            .map { it as Success }
}

fun <T> Flowable<Success<T>>.nonNullValueOnly(): Flowable<T> {
    return this.filter { it.value != null }
            .map { it.value!! }
}

fun <T> Flowable<Result<T>>.getSuccessfulNonNullValue(): Flowable<T> {
    return this.successOnly().nonNullValueOnly()
}

fun <T> Maybe<Result<T>>.successOnly(): Maybe<Success<T>> {
    return this.filter { it is Success }
            .map { it as Success }
}

fun <T> Maybe<Success<T>>.nonNullValueOnly(): Maybe<T> {
    return this.filter { it.value != null }
            .map { it.value!! }
}

fun <T> Maybe<Result<T>>.getSuccessfulNonNullValue(): Maybe<T> {
    return this.successOnly().nonNullValueOnly()
}

fun <T> Single<Result<T>>.successOnly(): Maybe<Success<T>> {
    return this.filter { it is Success }
            .map { it as Success }
}

fun <T> Single<Success<T>>.nonNullValueOnly(): Maybe<T> {
    return this.filter { it.value != null }
            .map { it.value!! }
}

fun <T> Single<Result<T>>.getSuccessfulNonNullValue(): Maybe<T> {
    return this.successOnly().nonNullValueOnly()
}