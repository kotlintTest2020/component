package com.liangjz.test.view;

import android.util.Log;

import io.reactivex.Observable;

public class Test3 {
    private void test(){
        Observable<String> observable = Observable.just("Hello", ", RxJava!!");
    }
}
