package com.liangjz.test.myapplication.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.liangjz.test.myapplication.R

class AppFragment : Fragment(){

    companion object{
        lateinit var instance : AppFragment
        fun getInstance() : Fragment{
            if(instance == null){
                instance = AppFragment()
            }
            return instance
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = layoutInflater.inflate(R.layout.fragment_app,container,false)
        return view
    }
}