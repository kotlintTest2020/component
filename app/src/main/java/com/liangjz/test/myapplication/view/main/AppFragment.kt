package com.liangjz.test.myapplication.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.liangjz.test.lib.base.BaseFragment
import com.liangjz.test.lib.router.ARouterPath
import com.liangjz.test.myapplication.R
import com.liangjz.test.myapplication.viewmodel.AppViewmodel

class AppFragment : BaseFragment(),AppAdapter.OnItemClickListener{

    override fun onItemClick(position: Int) {
        ARouter.getInstance().build(ARouterPath.Pic.picActivity).navigation()
    }

    lateinit var mRecycleview : RecyclerView
    lateinit var mAdapter : AppAdapter

    override fun createView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = layoutInflater.inflate(R.layout.fragment_app,container,false)
        return view
    }
    override fun bindView() {
        mRecycleview = findViewById(R.id.app_rv)
    }
    companion object{
        var instance = AppFragment()
        fun getInstance() : Fragment{
            return instance
        }
    }

    override fun initData() {
        mAdapter = AppAdapter()
        mAdapter.setOnItemClickListener(this)
        var layoutManage = GridLayoutManager(this.context,3)
        mRecycleview.layoutManager = layoutManage
        mRecycleview.adapter = mAdapter
        var viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(this.activity!!.application)).get(AppViewmodel::class.java)
        viewModel.getAppList().observe(this, Observer{
            mAdapter.setAppData(it)
        })
    }
}
