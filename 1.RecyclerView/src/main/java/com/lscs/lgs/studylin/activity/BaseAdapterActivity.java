package com.lscs.lgs.studylin.activity;

import android.graphics.Path;
import android.view.View;
import android.widget.TextView;

import com.lscs.lgs.annotationlib.ContentView;
import com.lscs.lgs.basemodule.base.BaseActivity;
import com.lscs.lgs.studylin.R;

/**
 * Created by Administrator on 2018/5/26/026.
 */
 @ContentView(R.layout.activity_base_adapter)
public class BaseAdapterActivity extends BaseActivity{

    @Override
    protected void initData() {
        TextView view = findViewById(R.id.textView);
        view.setText(R.string.base_adapter);
        view.setText("");
    }
}
