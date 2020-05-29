package com.liangjz.test.lib

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

class BaseApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        ARouter.init(this)
    }
}