package com.liangjz.test.repository

import android.util.Log
import com.liangjz.test.bean.PicBean
import com.liangjz.test.service.PicService
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class PicRepository {

    fun getPics() : List<PicBean>?{
        var retrofit = Retrofit.Builder().baseUrl("http://www.bing.com/HPImageArchive.aspx/").build()
        var service = retrofit.create(PicService::class.java)
        val call = service.getPic(10)
        call.enqueue(object:Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                print(t.message)
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                println(response.body())
            }

        })
        return null
    }
}