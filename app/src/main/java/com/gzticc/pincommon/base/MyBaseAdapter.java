package com.gzticc.pincommon.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by user on 2017/5/21.
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {

    protected List<T> data;
    protected Context mContext;
    protected LayoutInflater inflater;

    public MyBaseAdapter(List<T> data,Context context) {
        this.data = data;
        this.mContext = context;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getMyView(position, convertView, parent);
    }

    public abstract View getMyView(int position, View convertView, ViewGroup parent);
}
