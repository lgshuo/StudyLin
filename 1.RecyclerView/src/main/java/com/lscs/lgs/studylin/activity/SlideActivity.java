package com.lscs.lgs.studylin.activity;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.lscs.lgs.annotationlib.ContentView;
import com.lscs.lgs.basemodule.base.BaseActivity;
import com.lscs.lgs.studylin.R;
import com.lscs.lgs.studylin.adapter.SlideAdapter;
import com.lscs.lgs.studylin.bean.SlideBean;
import com.lscs.lgs.studylin.touch.slide.ItemTouchHelperCallback;
import com.lscs.lgs.studylin.touch.slide.OnSlideListener;
import com.lscs.lgs.studylin.touch.slide.SlideLayoutManager;

import java.util.ArrayList;

@ContentView(R.layout.activity_main)
public class SlideActivity extends BaseActivity {
    private ArrayList<SlideBean> mList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ItemTouchHelperCallback mItemTouchHelperCallback;
    private ItemTouchHelper mItemTouchHelper;
    private SlideLayoutManager mSlideLayoutManager;
    private SlideAdapter mAdapter;

    @Override
    protected void initData() {
        initList();
        recyclerView = findViewById(R.id.recycler_View);
        mAdapter = new SlideAdapter(R.layout.item_activity_slide, mList);
        recyclerView.setAdapter(mAdapter);
        mItemTouchHelperCallback = new ItemTouchHelperCallback(recyclerView.getAdapter(), mList);
        mItemTouchHelper = new ItemTouchHelper(mItemTouchHelperCallback);
        mSlideLayoutManager = new SlideLayoutManager(recyclerView, mItemTouchHelper);
        mItemTouchHelper.attachToRecyclerView(recyclerView);
        recyclerView.setLayoutManager(mSlideLayoutManager);
    }

    private void initList() {
        mList.add(new SlideBean("只想优雅转身,不料华丽撞墙。", R.mipmap.pic1));
        mList.add(new SlideBean("别再玩手机了,对手机不好。", R.mipmap.pic2));
        mList.add(new SlideBean("闯红灯?成功了,快几十秒;不成功,快一辈子。", R.mipmap.pic3));
        mList.add(new SlideBean("没有善后的能力,就别有善变的脾气。", R.mipmap.pic4));
        mList.add(new SlideBean("没有善后的能力,就别有善变的脾气。", R.mipmap.pic4));
        mList.add(new SlideBean("没有善后的能力,就别有善变的脾气。", R.mipmap.pic4));
        mList.add(new SlideBean("没有善后的能力,就别有善变的脾气。", R.mipmap.pic4));
    }
}
