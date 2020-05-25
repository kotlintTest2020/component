package com.liangjz.test.view.pics

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.liangjz.test.bean.Image
import com.liangjz.test.bean.PicBean
import com.liangjz.test.view.R

class PicAdapter(var picBean: PicBean?) : RecyclerView.Adapter<PicAdapter.ViewHolder>() {
    lateinit var mContext : Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.pic_recycleview_item, parent, false)
        mContext = parent.context
        return ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
         var mIv: ImageView
         var mTextView : TextView
        init {
            mIv = view.findViewById(R.id.pic_item_iv)
            mTextView = view.findViewById(R.id.pic_item_tv)
        }
    }

    override fun onBindViewHolder(holder: PicAdapter.ViewHolder, position: Int) {
        Glide.with(mContext)
                .load("http://www.bing.com${picBean?.images?.get(position)?.url}")
                .into(holder.mIv)
        holder.mTextView.setText(picBean?.images?.get(position)?.copyright)
        holder.mIv.setOnClickListener(View.OnClickListener {
            listener?.onItemClick(holder.mIv,position,picBean?.images)
        })
    }


    override fun getItemCount(): Int {
        return picBean?.images?.size?:0
    }

    public fun setData(picBean: PicBean){
        this.picBean = picBean
        this.notifyDataSetChanged()
    }
    public fun addOnClickListener(onItemClickListener: OnItemClickListener){
        this.listener = onItemClickListener
    }
    lateinit var listener : PicAdapter.OnItemClickListener
    interface OnItemClickListener{
        fun onItemClick(view:ImageView,position: Int,images: List<Image>?)
    }
}