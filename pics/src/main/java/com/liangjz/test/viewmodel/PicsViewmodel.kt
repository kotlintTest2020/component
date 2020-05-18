package com.liangjz.test.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.liangjz.test.bean.PicBean
import com.liangjz.test.repository.PicRepository

class PicsViewmodel :ViewModel() {
    var picLiveData : MutableLiveData<PicBean>? = null
    fun getPics() : MutableLiveData<PicBean>?{
        if(picLiveData == null){
            loadPics()
        }
        return picLiveData
    }

    /**
     * 获取pic列表
     */
    private fun loadPics() {
        PicRepository().getPics()
    }
}