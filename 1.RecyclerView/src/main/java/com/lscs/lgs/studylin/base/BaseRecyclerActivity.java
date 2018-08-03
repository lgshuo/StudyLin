package com.lscs.lgs.studylin.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lscs.lgs.annotationlib.ContentView;
import com.lscs.lgs.basemodule.base.BaseActivity;
import com.lscs.lgs.studylin.R;
import com.lscs.lgs.studylin.activity.SimpleAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/5/24/024.
 */
public abstract class BaseRecyclerActivity extends BaseActivity {
    protected ArrayList<String> list = new ArrayList<>();
    protected RecyclerView mRecyclerView;
    private SimpleAdapter mAdapter;

    @Override
    protected void initData() {
        initListData();
        mRecyclerView = findViewById(R.id.recycler_View);
        mAdapter = new SimpleAdapter(R.layout.item_recycler_simple,list);
        mRecyclerView.setAdapter(mAdapter);
    }

    protected void initListData() {
        for (int i = 0; i <49; i++) {
            list.add("数据" + i);
        }
    }
}
