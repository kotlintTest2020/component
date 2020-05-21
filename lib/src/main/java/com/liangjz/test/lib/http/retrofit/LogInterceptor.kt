package com.liangjz.test.lib.http.retrofit

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class LogInterceptor : Interceptor {
    private val TAG = "okhttp"
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        Log.e(TAG,request.toString())
        var t1 = System.nanoTime()
        var response = chain.proceed(request)
        var t2 = System.nanoTime()
        Log.e(TAG,"received response for ${response.request().url()} in ${t2 - t1}")
        var mediaType = response.body()?.contentType()
        var content = response.body()?.string()
        Log.e(TAG,"response body : $content")
        return response.newBuilder().body(okhttp3.ResponseBody.create(mediaType,content)).build()
    }
}