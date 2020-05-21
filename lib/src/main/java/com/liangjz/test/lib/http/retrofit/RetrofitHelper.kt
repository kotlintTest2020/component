package com.liangjz.test.lib.http.retrofit

import io.reactivex.plugins.RxJavaPlugins
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitHelper private constructor(){
    var baseUrl = "http://www.bing.com/HPImageArchive.aspx/"
    var mRetrofit : Retrofit? = null
    init {
        var logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        var okHttpClient = OkHttpClient().newBuilder()
                .connectTimeout(60,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build()

        mRetrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }
    companion object{
        val instance by lazy (LazyThreadSafetyMode.SYNCHRONIZED){
            RetrofitHelper()
        }
    }
    fun <T> create(clazz: Class<T>) : T? {
        return mRetrofit?.create(clazz)
    }

}