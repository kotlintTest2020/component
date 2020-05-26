package com.liangjz.test.myapplication.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.liangjz.test.myapplication.R

class MainActivity :AppCompatActivity(){
    @BindView(R.id.tabLayout)
    lateinit var tabLayout :TabLayout
    @BindView(R.id.viewpage2)
    lateinit var viewPager2 :ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        initUi()
    }

    private fun initUi() {
        viewPager2.adapter = MainFragmentAdapter(this)
        TabLayoutMediator(
                tabLayout,
                viewPager2,
                TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                    when (position) {
                        0 -> tab.text = "First"
                        1 -> tab.text = "Second"
                        else -> tab.text = "Third"
                    }
                }).attach()
    }
}