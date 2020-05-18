package com.liangjz.test.view.pics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.liangjz.test.view.R
import com.liangjz.test.viewmodel.PicsViewmodel

class PicsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pics)
        var picsViewmodel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(PicsViewmodel::class.java)
        picsViewmodel.getPics()?.observe(this, Observer {

        })

    }
}
