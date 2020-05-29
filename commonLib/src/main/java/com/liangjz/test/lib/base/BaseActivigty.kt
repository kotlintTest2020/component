package com.liangjz.test.lib.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivigty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateView(savedInstanceState)
        bindView()
        initData()
    }
    abstract fun onCreateView(savedInstanceState: Bundle?)
    abstract fun bindView()
    abstract fun initData()
}