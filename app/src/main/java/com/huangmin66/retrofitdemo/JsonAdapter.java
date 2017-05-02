package com.huangmin66.retrofitdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huangmin66.retrofitdemo.bean.Cook;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 描述：
 * 作者： 天天童话丶
 * 时间： 2017/4/19.
 */
public class JsonAdapter extends BaseAdapter {
    private Context context;
    private List<Cook> list = new ArrayList<>();

    public JsonAdapter(Context context, List<Cook> list){
        this.context = context;
//        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return list.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.layout_json_item, viewGroup, false);
            view.setTag(new ViewHolder(view));
        }
        ViewHolder holder = (ViewHolder) view.getTag();
        Cook cook = list.get(i);
        holder.title.setText(cook.getName());
        holder.info.setText(cook.getDescription());
        Picasso.with(context).load("http://tnfs.tngou.net/img" + cook.getImg()).into(holder.image);

        return view;
    }

    public void addAll(Collection<? extends Cook> collection){
        list.addAll(collection);
        notifyDataSetChanged();
    }

    public static class ViewHolder{
        private ImageView image;
        private TextView title;
        private TextView info;

        public ViewHolder(View item){
            image = (ImageView)item.findViewById(R.id.item_image);
            title = (TextView)item.findViewById(R.id.item_title);
            info = (TextView)item.findViewById(R.id.item_info);
        }
    }
}
