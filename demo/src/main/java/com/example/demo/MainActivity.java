package com.example.demo;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.demo.adapter.MainAdapter;
import com.example.demo.bean.ListDataBean;
import com.lscs.lgs.annotationlib.ContentView;
import com.lscs.lgs.basemodule.base.BaseActivity;

import java.util.ArrayList;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {
    private ArrayList<ListDataBean> mList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private MainAdapter mAdapter;


    private void initList() {
        mList.add(new ListDataBean("circleAnimStart",CircleAnimActivity.class));
    }

    @Override
    protected void initData() {
        initList();
        mRecyclerView = findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MainAdapter(R.layout.item_activity_main, mList);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    protected void initEvent() {
        super.initEvent();

    }
}
