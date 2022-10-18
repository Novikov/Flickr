package com.app.data.remote_data_source.utils

import com.app.data.remote_data_source.data_source_impl.base.Result
import com.app.data.remote_data_source.utils.NetworkConst.INITIAL_BUFFER_SIZE
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.annotations.BackpressureKind
import io.reactivex.annotations.BackpressureSupport
import io.reactivex.annotations.CheckReturnValue
import io.reactivex.annotations.SchedulerSupport

@CheckReturnValue
@BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
@SchedulerSupport(SchedulerSupport.NONE)
fun <T> Flowable<T>.asResult(): Flowable<Result<T>> =
    map { data -> Result.Success(data) as Result<T> }
        .onErrorReturn { throwable -> Result.Error(throwable) }
        .startWith(Result.Loading(isProgressBarVisible = true))

@CheckReturnValue
@BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
@SchedulerSupport(SchedulerSupport.NONE)
fun <T> Single<T>.asResult(): Flowable<Result<T>> =
    map { data -> Result.Success(data) as Result<T> }
        .onErrorReturn { throwable -> Result.Error(throwable) }
        .toFlowable()
        .startWith(Result.Loading(isProgressBarVisible = true))

@CheckReturnValue
@BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
@SchedulerSupport(SchedulerSupport.NONE)
fun <T> Flowable<T>.replayRefcount() = replay(INITIAL_BUFFER_SIZE).refCount()
