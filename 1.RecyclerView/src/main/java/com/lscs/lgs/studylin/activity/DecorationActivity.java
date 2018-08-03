package com.lscs.lgs.studylin.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lscs.lgs.annotationlib.ContentView;
import com.lscs.lgs.basemodule.base.BaseActivity;
import com.lscs.lgs.studylin.R;
import com.lscs.lgs.studylin.adapter.MainAdapter;
import com.lscs.lgs.studylin.bean.MainListBean;

import java.util.ArrayList;
import java.util.List;


@ContentView(R.layout.activity_main)
public class DecorationActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private List<MainListBean> mList = new ArrayList<>();


    @Override
    protected void initData() {
        initList();
        mRecyclerView = findViewById(R.id.recycler_View);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new MainAdapter(this,mList));
    }

    private void initList() {
        mList.add(new MainListBean("垂直方向RecyclerView",VerticalDecorationActivity.class));
        mList.add(new MainListBean("水平方向RecyclerView", HorizontalDecorationActivity.class));
        mList.add(new MainListBean("垂直方向包含头尾",ExpendVerticalDecorationActivity.class));
        mList.add(new MainListBean("水平方向包含头尾",ExpendHorizontalDecorationActivity.class));
        mList.add(new MainListBean("GridView",GridDecorationActivity.class));
        mList.add(new MainListBean("GridView带头尾",AroundGridDecorationActivity.class));
    }
}
