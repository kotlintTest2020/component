package com.liangjz.test.myapplication.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.liangjz.test.myapplication.R;
import com.liangjz.test.myapplication.bean.database.Book;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    private Context mContext;
    private List<Book> mData;
    public ListAdapter(Context context, List<Book> list){
        this.mContext = context;
        this.mData = list;
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.listview_item,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.nameTv.setText(mData.get(position).getName());
        holder.colorTv.setText(mData.get(position).getColor());
        holder.countTv.setText(mData.get(position).getCout()+"");
        holder.priceTv.setText(mData.get(position).getPrice());
        return convertView;
    }

    class ViewHolder{
        public TextView nameTv;
        public TextView colorTv;
        public TextView countTv;
        public TextView priceTv;
        public ViewHolder(View view){
            nameTv = (TextView)view.findViewById(R.id.name);
            colorTv = (TextView)view.findViewById(R.id.color);
            countTv = (TextView)view.findViewById(R.id.count);
            priceTv = (TextView)view.findViewById(R.id.price);
        }
    }

}
