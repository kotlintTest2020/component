package com.liangjz.test.myapplication.view.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.liangjz.test.myapplication.R
import com.liangjz.test.myapplication.bean.AppInfoBean

class AppAdapter : RecyclerView.Adapter<AppAdapter.ViewHolder>() {
    var list : List<AppInfoBean> = ArrayList<AppInfoBean>()
    var listener : AppAdapter.OnItemClickListener? = null
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var appName : TextView
        var itemLayout : LinearLayout
        init {
            appName = view.findViewById(R.id.app_name)
            itemLayout = view.findViewById(R.id.tv_item_ll)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_app_rv_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AppAdapter.ViewHolder, position: Int) {
        holder.appName.setText(list.get(position).appName)
        holder.itemLayout.setOnClickListener({
            listener?.onItemClick(position)
         }
        )
    }
    fun setOnItemClickListener(listener : OnItemClickListener){
        this.listener = listener
    }
    interface OnItemClickListener{
        fun onItemClick(position : Int)
    }
    fun setAppData(list : List<AppInfoBean>){
        this.list = list
        notifyDataSetChanged()
    }

}