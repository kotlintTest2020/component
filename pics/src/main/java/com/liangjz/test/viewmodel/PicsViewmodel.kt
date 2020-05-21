package com.liangjz.test.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.liangjz.test.bean.PicBean
import com.liangjz.test.repository.PicRepository
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class PicsViewmodel : ViewModel() {
    var picLiveData: MutableLiveData<PicBean>? = null
    fun getPics(): MutableLiveData<PicBean>? {
        if (picLiveData == null) {
            loadPics()
        }
        return picLiveData
    }

    /**
     * 获取pic列表
     */
    private fun loadPics() {
        PicRepository()
                .getPics<PicBean>()?.subscribe(object: Observer<PicBean> {
                    override fun onComplete() {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onSubscribe(d: Disposable) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onNext(t: PicBean) {
                        if (t != null) {
                            for (item in t.images) {
                                Log.i("picviewmodel", "copyright:${item.copyright},url:${item.url}")
                            }
                        }
                    }

                    override fun onError(e: Throwable) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })
    }
}


