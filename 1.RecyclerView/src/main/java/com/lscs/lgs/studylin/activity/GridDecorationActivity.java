package com.lscs.lgs.studylin.activity;

import android.support.v7.widget.GridLayoutManager;

import com.lscs.lgs.annotationlib.ContentView;
import com.lscs.lgs.studylin.R;
import com.lscs.lgs.studylin.base.BaseRecyclerActivity;
import com.lscs.lgs.studylin.view.AroundGridDividerItemDecoration;
import com.lscs.lgs.studylin.view.GridDividerItemDecoration;

/**
 * Created by Administrator on 2018/5/24/024.
 */
@ContentView(R.layout.activity_main)
public class GridDecorationActivity extends BaseRecyclerActivity {

    @Override
    protected void initData() {
        super.initData();
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        mRecyclerView.addItemDecoration(new GridDividerItemDecoration(this));
    }
}
