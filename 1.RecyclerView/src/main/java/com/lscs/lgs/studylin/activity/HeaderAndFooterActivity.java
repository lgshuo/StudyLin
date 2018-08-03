package com.lscs.lgs.studylin.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.lscs.lgs.annotationlib.ContentView;
import com.lscs.lgs.basemodule.base.BaseActivity;
import com.lscs.lgs.studylin.R;
import com.lscs.lgs.studylin.adapter.MainAdapter;
import com.lscs.lgs.studylin.adapter.WapHeaderAndFooterAdapter;
import com.lscs.lgs.studylin.bean.MainListBean;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_main)
public class HeaderAndFooterActivity extends BaseActivity {


    private RecyclerView recyclerView;
    private MainAdapter myAdapter;
    private WapHeaderAndFooterAdapter headerAndFooterAdapter;
    private List<MainListBean> datas;


    @Override
    protected void initData() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_View);
        datas = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            datas.add(new MainListBean(i + "",null));
        }
        myAdapter = new MainAdapter(this, datas);
        headerAndFooterAdapter = new WapHeaderAndFooterAdapter(myAdapter);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(linearLayoutManager);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        View header = LayoutInflater.from(this).inflate(R.layout.header_view, recyclerView, false);
        View footer = LayoutInflater.from(this).inflate(R.layout.footer_view, recyclerView, false);

        headerAndFooterAdapter.addHeader(header);
        headerAndFooterAdapter.addFooter(footer);

        recyclerView.setAdapter(headerAndFooterAdapter);
        headerAndFooterAdapter.setOnloadMoreListener(new WapHeaderAndFooterAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                Toast.makeText(HeaderAndFooterActivity.this, "加载更多", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClickLoadMore() {
                Toast.makeText(getApplicationContext(), "我:加载更多被点击了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(View view, int position) {

            }
        }, recyclerView);
    }
}