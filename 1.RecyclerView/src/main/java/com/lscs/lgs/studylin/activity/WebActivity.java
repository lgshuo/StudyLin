package com.lscs.lgs.studylin.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import com.just.agentweb.AgentWeb;
import com.lscs.lgs.annotationlib.ContentView;
import com.lscs.lgs.basemodule.base.BaseActivity;
import com.lscs.lgs.studylin.R;

@ContentView(R.layout.activity_web)
public class WebActivity extends BaseActivity {

    private RelativeLayout relative;
    private AgentWeb mAgentWeb;

    @Override
    protected void initData() {
        relative = findViewById(R.id.relative);
        String link = getIntent().getStringExtra("link");
        mAgentWeb = AgentWeb.with(this)//传入Activity or Fragment
                .setAgentWebParent(relative, new RelativeLayout.LayoutParams(-1,
                        -1))//传入AgentWeb 的父控件 ，如果父控件为 RelativeLayout ， 那么第二参数需要传入 RelativeLayout.LayoutParams ,第一个参数和第二个参数应该对应。
                .useDefaultIndicator()// 使用默认进度条
                .createAgentWeb()
                .ready()
                .go(link);
//                .go("http://www.baidu.com");

    }

    public static void actionStart(Context activity, String link) {
        Intent intent = new Intent(activity, WebActivity.class);
        intent.putExtra("link", link);
        activity.startActivity(intent);
    }
}
