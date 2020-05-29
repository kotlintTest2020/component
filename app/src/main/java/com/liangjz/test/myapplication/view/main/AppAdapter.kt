package com.liangjz.test.myapplication.view.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.liangjz.test.myapplication.R
import com.liangjz.test.myapplication.bean.AppInfoBean

class AppAdapter : RecyclerView.Adapter<AppAdapter.ViewHolder>() {
    var list : List<AppInfoBean> = ArrayList<AppInfoBean>()
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var appName : TextView
        init {
            appName = view.findViewById(R.id.app_name)
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
    }

    fun setAppData(list : List<AppInfoBean>){
        this.list = list
        notifyDataSetChanged()
    }

}