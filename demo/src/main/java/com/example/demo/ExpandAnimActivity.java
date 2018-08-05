package com.example.demo;

import android.view.View;

import com.example.myutils.anim.ExpandAnimUtil;
import com.lscs.lgs.annotationlib.ContentView;
import com.lscs.lgs.basemodule.base.BaseActivity;
@ContentView(R.layout.activity_expand)
public class ExpandAnimActivity extends BaseActivity {
    private View mHideView;
    private int animHeight;
    private boolean isFrist = true;
    private View mControllView;


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && isFrist) {
            isFrist = false;
            animHeight = mHideView.getHeight();
            ExpandAnimUtil.newInstance(mHideView, mControllView, animHeight,1000);

        }
    }

    @Override
    protected void initData() {
        mControllView = findViewById(R.id.view3);
        mHideView = findViewById(R.id.view2);
    }
}