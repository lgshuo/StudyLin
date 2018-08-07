package com.lscs.lgs.studylin.activity;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lscs.lgs.annotationlib.ContentView;
import com.lscs.lgs.basemodule.base.BaseActivity;
import com.lscs.lgs.studylin.adapter.MainAdapter;
import com.lscs.lgs.studylin.bean.MainListBean;
import com.lscs.lgs.studylin.R;
import com.lscs.lgs.studylin.cons.Url;

import java.util.ArrayList;
import java.util.List;


@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private List<MainListBean> mList = new ArrayList<>();


    @Override
    protected void initData() {
        initList();
        mRecyclerView = findViewById(R.id.recycler_View);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(new MainAdapter(this,mList));
    }

    private void initList() {
        mList.add(new MainListBean("LayoutManager分割线",DecorationActivity.class));
        mList.add(new MainListBean("添加RecyclerView头,尾",HeaderAndFooterActivity.class));
        mList.add(new MainListBean("实现仿探探效果", SlideActivity.class));
        mList.add(new MainListBean("实现仿ViewPager横向滑动效果", ViewPagerActivity.class));
        mList.add(new MainListBean("实现仿抖音纵向滑动效果", WebActivity.class, Url.shorVideoLink));
        mList.add(new MainListBean("自定义Adapter基类",BaseAdapterActivity.class));
    }
}
