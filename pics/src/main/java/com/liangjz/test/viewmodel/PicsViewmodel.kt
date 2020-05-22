package com.liangjz.test.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.liangjz.test.bean.Image
import com.liangjz.test.bean.PicBean
import com.liangjz.test.bean.Tooltips
import com.liangjz.test.repository.PicRepository
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class PicsViewmodel : ViewModel() {
    var picLiveData: MutableLiveData<PicBean>? = null
    fun getPics(): MutableLiveData<PicBean> {
        if (picLiveData == null) {
            picLiveData = MutableLiveData()
            loadPics()
        }
        return picLiveData!!
    }

    /**
     * 获取pic列表
     */
    private fun loadPics() {
        var disposable = PicRepository()
                .getPics<PicBean>()?.subscribe(object: Observer<PicBean> {
                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(t: PicBean) {
                        if (t != null) {
                            for (item in t.images) {
                                Log.i("picviewmodel", "copyright:${item.copyright},url:${item.url}")
                            }
                            picLiveData?.postValue(t)
                        }
                    }

                    override fun onError(e: Throwable) {
                        Log.i("picviewmodel","${e.cause },${e.message}" )
                    }

                })
    }
}


