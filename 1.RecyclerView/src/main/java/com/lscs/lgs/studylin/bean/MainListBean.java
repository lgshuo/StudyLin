package com.lscs.lgs.studylin.bean;

import android.app.Activity;

import java.io.PipedReader;

/**
 * Created by Administrator on 2018/5/24/024.
 */

public class MainListBean {
    private String buttonName;
    private Class<? extends Activity> mActivity;

    public MainListBean(String buttonName, Class activity) {
        this.buttonName = buttonName;
        mActivity = activity;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public Class getActivity() {
        return mActivity;
    }

    public void setActivity(Class activity) {
        mActivity = activity;
    }
}
