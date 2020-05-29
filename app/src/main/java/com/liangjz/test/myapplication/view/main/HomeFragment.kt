package com.liangjz.test.myapplication.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.liangjz.test.lib.base.BaseFragment
import com.liangjz.test.myapplication.R

class HomeFragment: BaseFragment() {

    companion object{
        var instance : HomeFragment = HomeFragment()
        fun getInstance() : Fragment{
            return instance
        }
    }
    override fun createView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = layoutInflater.inflate(R.layout.fragment_home,container,false)
        return view
    }
    override fun initData() {
    }

    override fun bindView() {
    }


}
