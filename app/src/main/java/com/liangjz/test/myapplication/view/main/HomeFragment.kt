package com.liangjz.test.myapplication.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.liangjz.test.myapplication.R

class HomeFragment : Fragment(){

    companion object{
        lateinit var instance : HomeFragment
        fun getInstance() : Fragment{
            if(instance == null){
                instance = HomeFragment()
            }
            return instance
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = layoutInflater.inflate(R.layout.fragment_home,container,false)
        return view
    }
}
