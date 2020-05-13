package com.liangjz.test.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.liangjz.test.bean.NewsBean

class NewsViewmodel : ViewModel() {
    var mLiveData : MutableLiveData<List<NewsBean>>? = null
    public fun getNews() : LiveData<List<NewsBean>>{
        if(mLiveData == null){
            mLiveData = MutableLiveData()
            loadNews()
        }
        return mLiveData!!
    }

    private fun loadNews() {
        val mNewsList = ArrayList<NewsBean>()
        for(i in 0..20){
            mNewsList.add(NewsBean("title$i","subtitle$i","time$i","content$i"))
        }
        mLiveData!!.postValue(mNewsList)
    }
}