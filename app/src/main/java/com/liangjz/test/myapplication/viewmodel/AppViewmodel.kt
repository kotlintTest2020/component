package com.liangjz.test.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.liangjz.test.myapplication.bean.AppInfoBean
import java.util.ArrayList

class AppViewmodel : ViewModel() {
    var appList : MutableLiveData<List<AppInfoBean>> = MutableLiveData()
    fun getAppList() : LiveData<List<AppInfoBean>>{
        loadData()
        return appList
    }

    private fun loadData() {
        var list = ArrayList<AppInfoBean>()
        list.add(AppInfoBean("","新闻"))
        list.add(AppInfoBean("","直播"))
        list.add(AppInfoBean("","图片"))
        appList.value = list
    }
}