package com.liangjz.test.lib.http.repository

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class BaseRepository {
    fun <T> schedulerTransform() : ObservableTransformer<T, T> {
        return ObservableTransformer {
            upstream ->  upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }
    }
}