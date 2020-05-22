package com.liangjz.test.api

import com.liangjz.test.bean.PicBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface PicService {
    @GET("?format=js&idx=0&mkt=zh-CN")
     fun getPic(@Query("n") pageSize : Int) : Observable<PicBean>
}