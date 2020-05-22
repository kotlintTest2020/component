package com.liangjz.test.view.pics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.liangjz.test.bean.PicBean
import com.liangjz.test.view.R
import com.liangjz.test.viewmodel.PicsViewmodel

class PicsActivity : AppCompatActivity() {
    @BindView(R.id.pic_recycleview)
    lateinit var mRecycleview : RecyclerView
    lateinit var picBean: PicBean
    lateinit var adapter: PicAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUi()
        setContentView(R.layout.activity_pics)
        getData()
    }

    private fun initUi() {
        adapter =  PicAdapter(picBean)
        mRecycleview.adapter = adapter
    }

    private fun getData() {
        var picsViewmodel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(PicsViewmodel::class.java)
        picsViewmodel.getPics()?.observe(this, Observer {
            Log.i("picsactivity",it.images.size.toString())
            picBean = it
            adapter.notifyDataSetChanged()
        })
    }
}
