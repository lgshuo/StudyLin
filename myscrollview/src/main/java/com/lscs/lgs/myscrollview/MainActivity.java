package com.lscs.lgs.myscrollview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lscs.lgs.annotationlib.ContentView;
import com.lscs.lgs.basemodule.base.BaseActivity;

import java.io.ObjectStreamException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {
    @BindView(R.id.fram_title_bar)
    View mParent;
    @BindView(R.id.top_parent)
    View topView;
    @BindView(R.id.bg_toolbar)
    ImageView mBgToolbar;
    @BindView(R.id.icon)
    ImageView mIcon;
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.title2)
    TextView mTitle2;

    @BindView(R.id.name)
    TextView mName;
    @BindView(R.id.date)
    TextView mDate;
    @BindView(R.id.webView)
    WebView mWebView;
    @BindView(R.id.scoll_view)
    StickyScrollView mScollView;
    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.share)
    ImageView mShare;
    @BindView(R.id.bg_fram)
    View mFram;
    private boolean ismeasure;
    private int mToolBarHeight;
    private int mToolBarWidth;
    private int mMeasureHeight;
    private int mTitleWidth;
    private int mTitleHeight;
    private float mTitleX;
    private float percent;
    private float bigTextSize;
    private float smallTextSize;


    protected void initEvent() {
        mScollView.setOnMyScollViewChangeListener(new StickyScrollView.OnMyScollViewChangeListener() {
            @Override
            public void onScrollChanged(int t) {
                percent = t * 1.0f / (mMeasureHeight - mToolBarHeight);
                if (percent <= 1) {
                    startAnim();
                    mParent.setBackgroundResource(android.R.color.transparent);
                    mTitle2.setVisibility(View.GONE);
                } else {
                    mParent.setBackgroundResource(R.color.colorAccent);
                    mTitle2.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    protected void initData() {
        ButterKnife.bind(this);
        mWebView.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            mWebView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        mWebView.loadUrl("https://github.com/Alan222?tab=repositories");
    }

    /**
     * 动画效果
     */
    private void startAnim() {
        animForTitle();
        animForAll();

    }

    private void animForAll() {
        mBgToolbar.setAlpha(1 - percent);
        mIcon.setAlpha(1 - percent);
        mName.setAlpha(1 - percent);
        mFram.setAlpha(1 - percent);
    }

    /**
     * 标题的移动动画
     */
    private void animForTitle() {
        float startX = mTitleX + mTitleWidth / 2.0f;
        float startY = mTitleHeight / 2.0f;

        float endX = mToolBarWidth / 2.0f;
        float endY = mToolBarHeight / 2.0f;
        mTitle.setTranslationX(percent * (endX - startX));
        mTitle.setTranslationY(percent * (endY - startY));
        mTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, bigTextSize - percent * (bigTextSize - smallTextSize));
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && !ismeasure) {         //获取焦点并且未测量
            ismeasure = true;
            measure();
        }
    }

    /**
     * 测量
     */
    private void measure() {
        mToolBarHeight = mParent.getHeight();
        mToolBarWidth = mParent.getWidth();
        mMeasureHeight = mBgToolbar.getHeight();
        mTitleWidth = mTitle.getWidth();
        mTitleHeight = mTitle.getHeight();
        mTitleX = mTitle.getX();
        bigTextSize = mTitle.getTextSize();
        smallTextSize = mTitle2.getTextSize();
    }

    @OnClick({R.id.back, R.id.share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                Toast.makeText(getApplicationContext(), "已返回", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                Toast.makeText(getApplicationContext(), "已分享", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
