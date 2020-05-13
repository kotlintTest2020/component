package com.liangjz.test.view.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import butterknife.BindView
import butterknife.ButterKnife
import com.liangjz.test.bean.NewsBean
import com.liangjz.test.view.R
import com.liangjz.test.viewmodel.NewsViewmodel

class NewsActivity : AppCompatActivity() {
    @BindView(R.id.news_recycleview) lateinit var mRecyclerView : RecyclerView
    lateinit var mAdapter : NewsAdapter
    lateinit var mList : List<NewsBean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        ButterKnife.bind(this)
        setData()
    }

    private fun setData() {
        mList = ArrayList()
        mAdapter = NewsAdapter(mList)
        var manager: LinearLayoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = manager
        mRecyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        mRecyclerView.adapter = mAdapter
        var factory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        var model = ViewModelProvider(this, factory).get(NewsViewmodel::class.java)
        model.getNews().observe(this, Observer {
            mList = it
            mAdapter.setNews(mList)
        })
    }

}
