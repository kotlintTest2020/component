package com.liangjz.test.view.pics

import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.liangjz.test.lib.base.BaseActivigty
import com.liangjz.test.view.R

class DetailActivity : BaseActivigty() {
    lateinit var mDetailIv : ImageView

    override fun onCreateView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_detail)
    }
    override fun bindView() {
        mDetailIv = findViewById(R.id.detail_iv)
    }
    override fun initData() {
        getData()
    }
    private fun getData() {
        var bundle = intent.extras
        var url = bundle.getString("url")
        Glide.with(this).load("http://www.bing.com$url").into(mDetailIv)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAfterTransition()
    }
}