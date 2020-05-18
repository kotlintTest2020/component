package com.liangjz.test.service

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PicService {
    @GET("?format=js&idx=0&mkt=zh-CN")
     fun getPic(@Query("n") pageSize : Int) : Call<ResponseBody>
}