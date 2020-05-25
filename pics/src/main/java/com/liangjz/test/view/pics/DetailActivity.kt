package com.liangjz.test.view.pics

import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.liangjz.test.view.R

class DetailActivity : AppCompatActivity() {
    @BindView(R.id.detail_iv)
    lateinit var mDetailIv : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        ButterKnife.bind(this)
        getData()
    }

    private fun getData() {
        var bundle = intent.extras
        var url = bundle.getString("url")
        Glide.with(this).load("http://www.bing.com$url").into(mDetailIv)
    }
}