package com.liangjz.test.myapplication.view.main

import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.liangjz.test.lib.base.BaseActivigty
import com.liangjz.test.myapplication.R

class MainActivity : BaseActivigty(){
    lateinit var tabLayout :TabLayout
    lateinit var viewPager2 :ViewPager2

    override fun onCreateView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        initUi()
    }

    override fun bindView() {
        tabLayout = findViewById(R.id.tabLayout)
        viewPager2 = findViewById(R.id.viewpage2)
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