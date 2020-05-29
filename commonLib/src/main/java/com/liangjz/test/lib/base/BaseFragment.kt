package com.liangjz.test.lib.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    lateinit var mView : View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = createView(inflater, container, savedInstanceState)
        if(view != null){
            mView = view
        }
        bindView()
        initData()
        return mView
    }

    abstract fun createView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View?
    abstract fun bindView()
    abstract fun initData()

    fun <T : View>findViewById(id:Int):T{
        return mView.findViewById(id)
    }
}