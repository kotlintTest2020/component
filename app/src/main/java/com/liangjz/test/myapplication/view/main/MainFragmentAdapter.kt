package com.liangjz.test.myapplication.view.main

import android.util.SparseArray
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainFragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){
    private val fragments : SparseArray<Fragment> = SparseArray()
    init {
        fragments.put(PAGE_HOME, HomeFragment.getInstance())
        fragments.put(PAGE_APP, AppFragment.getInstance())
    }
    override fun getItemCount(): Int {
        return fragments.size()
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
    companion object {

        const val PAGE_HOME = 0

        const val PAGE_APP = 1

        const val PAGE_INDICATOR = 2

        const val PAGE_OTHERS = 3

    }
}