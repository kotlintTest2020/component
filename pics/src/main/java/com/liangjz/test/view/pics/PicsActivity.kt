package com.liangjz.test.view.pics

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liangjz.test.bean.Image
import com.liangjz.test.lib.base.BaseActivigty
import com.liangjz.test.view.R
import com.liangjz.test.viewmodel.PicsViewmodel

class PicsActivity : BaseActivigty() , PicAdapter.OnItemClickListener {
    override fun onItemClick(view : ImageView, position: Int, images: List<Image>?) {
        var i = Intent(this,DetailActivity::class.java)
        var bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(this, view,getString(R.string.share_pic_name)).toBundle()
        bundle?.putString("url",images?.get(position)?.url)
        i.putExtras(bundle)
        startActivity(i,bundle)
    }

    lateinit var mRecycleview : RecyclerView
    lateinit var adapter: PicAdapter
    override fun onCreateView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_pics)
    }
    override fun bindView() {
        mRecycleview = findViewById(R.id.pic_recycleview)
    }
    override fun initData() {
        adapter =  PicAdapter(null)
        adapter.addOnClickListener(this)
        val layoutManager = GridLayoutManager(this,2)
        mRecycleview.layoutManager = layoutManager
        mRecycleview.adapter = adapter
        getData()
    }

    private fun getData() {
        var picsViewmodel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(PicsViewmodel::class.java)
        picsViewmodel.getPics()?.observe(this, Observer {
            Log.i("picsactivity",it.images.size.toString())
            adapter.setData(it)
        })
    }

}
