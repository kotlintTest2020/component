package com.liangjz.test.view.pics

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.liangjz.test.bean.Image
import com.liangjz.test.view.R
import com.liangjz.test.viewmodel.PicsViewmodel

class PicsActivity : AppCompatActivity() , PicAdapter.OnItemClickListener {
    override fun onItemClick(view : ImageView, position: Int, images: List<Image>?) {
        var i = Intent(this,DetailActivity::class.java)
        var bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(this, Pair(view,getString(R.string.share_pic_name))).toBundle()
        bundle?.putString("url",images?.get(position)?.url)
        i.putExtras(bundle)
        startActivity(i)
    }

    @BindView(R.id.pic_recycleview)
    lateinit var mRecycleview : RecyclerView
    lateinit var adapter: PicAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pics)
        ButterKnife.bind(this)
        initUi()
        getData()
    }

    private fun initUi() {
        adapter =  PicAdapter(null)
        adapter.addOnClickListener(this)
        val layoutManager = GridLayoutManager(this,2)
        mRecycleview.layoutManager = layoutManager
        mRecycleview.adapter = adapter
    }

    private fun getData() {
        var picsViewmodel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(PicsViewmodel::class.java)
        picsViewmodel.getPics()?.observe(this, Observer {
            Log.i("picsactivity",it.images.size.toString())
            adapter.setData(it)
        })
    }

}
