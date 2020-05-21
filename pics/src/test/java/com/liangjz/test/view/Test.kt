package com.liangjz.test.view

import android.content.Intent
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import org.junit.Test

class Test {
    @Test
    fun test() {
        Observable.just("h").subscribe(object:Observer<String>{
            override fun onComplete() {
                print("complete")
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: String) {
                print(t)
            }

            override fun onError(e: Throwable) {
            }

        })
    }

}
