package com.gzticc.pincommon;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gzticc.pincommon.ui.adapter.RecyclerViewAdapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecyclerViewActivity1 extends AppCompatActivity implements RecyclerViewAdapter1.OnChildClickListener {
    @Bind(R.id.recycler)
    RecyclerView recycler;
    private  RecyclerViewAdapter1 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view1);
        ButterKnife.bind(this);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            list.add(String.format(Locale.CHINA,"第%03d条数据",i));
        }
        adapter = new RecyclerViewAdapter1(this,list);
        adapter.setOnChildClickListener(this);
        recycler.setAdapter(adapter);

    }

    @Override
    public void onChildClick(RecyclerView parent, View view, int position, String data) {
        Snackbar.make(view,data,Snackbar.LENGTH_SHORT).show();
        adapter.remove(position);
    }
}
