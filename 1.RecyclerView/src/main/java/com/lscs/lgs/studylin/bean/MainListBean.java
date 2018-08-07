package com.lscs.lgs.studylin.bean;

import android.app.Activity;

import java.io.PipedReader;

/**
 * Created by Administrator on 2018/5/24/024.
 */

public class MainListBean {
    private String buttonName;
    private Class<? extends Activity> mActivity;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    private String link;

    public MainListBean(String buttonName, Class<? extends Activity> mActivity, String link) {
        this.buttonName = buttonName;
        this.mActivity = mActivity;
        this.link = link;
    }

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
