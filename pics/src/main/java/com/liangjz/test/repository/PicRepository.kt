package com.liangjz.test.repository

import com.liangjz.test.bean.PicBean
import com.liangjz.test.lib.http.retrofit.RetrofitHelper
import com.liangjz.test.service.PicService
import io.reactivex.Observable

class PicRepository {
     fun <T> getPics() : Observable<PicBean>? {
        var observable : Observable<PicBean>? = RetrofitHelper.instance.create(PicService::class.java)?.getPic(10)
         return observable
    }
}