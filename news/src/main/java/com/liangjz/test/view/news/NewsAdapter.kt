package com.liangjz.test.view.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.liangjz.test.bean.NewsBean
import com.liangjz.test.view.R

class NewsAdapter(var mNewsList: List<NewsBean>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var mTitle: TextView
        lateinit var mSubTitle: TextView
        lateinit var mContent: TextView

        init {
            mTitle = view.findViewById(R.id.textView)
            mSubTitle = view.findViewById(R.id.textView2)
            mContent = view.findViewById(R.id.textView3)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
        var holder : ViewHolder = ViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return mNewsList.size
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        var news : NewsBean = mNewsList.get(position)
        holder.mTitle.setText(news.title)
        holder.mSubTitle.setText(news.subTitle)
        holder.mContent.setText(news.content)
    }

    public fun setNews(list : List<NewsBean>){
        mNewsList = list
        notifyDataSetChanged()
    }
}