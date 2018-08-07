package com.lscs.lgs.studylin.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;

import com.lscs.lgs.annotationlib.ContentView;
import com.lscs.lgs.basemodule.base.BaseActivity;
import com.lscs.lgs.studylin.R;
import com.lscs.lgs.studylin.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_pager)
public class ViewPagerActivity extends BaseActivity{
    private List<String> mList = new ArrayList<>();
    private LinearLayoutManager layoutManager;

    @Override
    protected void initData() {
        initList();
        RecyclerView recyclerView = findViewById(R.id.recycler_View);
        ViewPagerAdapter adapter = new ViewPagerAdapter(R.layout.item_activity_view_pager, mList);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
    }

    private void initList() {
        for (int i = 0; i < 10; i++) {
            mList.add(i + "");
        }
    }

    public void switchX(View view) {
        if (layoutManager.getOrientation() == LinearLayoutManager.HORIZONTAL) {
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        } else {
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        }
    }
}
