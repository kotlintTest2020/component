package com.liangjz.test.view.pics

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.liangjz.test.bean.PicBean
import com.liangjz.test.view.R

class PicAdapter(var picBean: PicBean?) : RecyclerView.Adapter<PicAdapter.ViewHolder>() {
    lateinit var mContext : Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.pic_recycleview_item, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var mIv: ImageView
        init {
            mIv = view.findViewById(R.id.pic_item_iv)
        }
    }

    override fun onBindViewHolder(holder: PicAdapter.ViewHolder, position: Int) {
        Glide.with(mContext)
                .load("http://www.bing.com${picBean?.images?.get(position)?.url}")
                .into(holder.mIv)
    }


    override fun getItemCount(): Int {
        return picBean?.images?.size?:0
    }

}