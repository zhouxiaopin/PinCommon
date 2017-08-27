package com.gzticc.pincommon.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gzticc.pincommon.R;

import java.util.List;

/**
 * Created by user on 2017/8/23.
 */

public class RecyclerViewAdapter1 extends RecyclerView.Adapter<RecyclerViewAdapter1.MyViewHolder> implements View.OnClickListener {
    private Context context;
    private List<String> list;
    private OnChildClickListener listener;
    private RecyclerView recyclerView;

    public void setOnChildClickListener(OnChildClickListener listener) {
        this.listener = listener;
    }

    public RecyclerViewAdapter1(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view1_item,parent,false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.item_text.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
        if (null != recyclerView && null != listener){
            int position = recyclerView.getChildAdapterPosition(v);
            listener.onChildClick(recyclerView,v,position,list.get(position));
        }
    }

    public void remove(int position){
        list.remove(position);
        //notifyDataSetChanged();
        notifyItemRemoved(position);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView item_text;

        public MyViewHolder(View itemView) {
            super(itemView);
            item_text = (TextView)itemView.findViewById(R.id.item_text);
        }
    }
    public interface OnChildClickListener{
        void onChildClick(RecyclerView parent, View view, int position,String data);
    }

}
