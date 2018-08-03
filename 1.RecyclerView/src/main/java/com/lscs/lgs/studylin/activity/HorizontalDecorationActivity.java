package com.lscs.lgs.studylin.activity;

import android.support.v7.widget.LinearLayoutManager;

import com.lscs.lgs.annotationlib.ContentView;
import com.lscs.lgs.studylin.R;
import com.lscs.lgs.studylin.base.BaseRecyclerActivity;
import com.lscs.lgs.studylin.view.LinearDividerItemDecoration;


/**
 * Created by Administrator on 2018/5/24/024.
 */
@ContentView(R.layout.activity_main)
public class HorizontalDecorationActivity extends BaseRecyclerActivity {

    @Override
    protected void initData() {
        super.initData();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.addItemDecoration(new LinearDividerItemDecoration(this, LinearDividerItemDecoration.HORIZENTAL_LIST));
    }
}
