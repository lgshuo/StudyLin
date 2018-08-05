package com.example.myutils.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

public class ExpandAnimUtil {

    private View controlView;
    private int mHeight;//伸展高度

    private View hideView;//需要展开隐藏的布局，开关控件
    private long mDuration = 0;

    /**
     * @param hideView 需要隐藏或显示的布局view
     * @param controlView 按钮开关的view
     * @param height 布局展开的高度(根据实际需要传)
     * @param duration 动画时长
     */
    public static ExpandAnimUtil newInstance(View hideView, View controlView, int height, long duration){
        return new ExpandAnimUtil(hideView,controlView,height,duration);
    }

    private ExpandAnimUtil(View hideView, View controlView, int height, long duration){
        this.hideView = hideView;
        this.controlView = controlView;
        this.mDuration = duration;
        mHeight = height;
        controlView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
            }
        });
    }

    /**
     * 开关
     */
    public void toggle(){
        if (View.VISIBLE == hideView.getVisibility()) {
            closeAnimate(hideView);//布局隐藏
        } else {
            openAnim(hideView);//布局铺开
        }
    }


    private void openAnim(View v) {
        v.setVisibility(View.VISIBLE);
        ValueAnimator animator = createDropAnimator(v, 0, mHeight);
        animator.start();
    }

    private void closeAnimate(final View view) {
        int origHeight = view.getHeight();
        ValueAnimator animator = createDropAnimator(view, origHeight, 0);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                view.setVisibility(View.GONE);
            }
        });
        animator.start();
    }

    private ValueAnimator createDropAnimator(final View v, int start, int end) {
        ValueAnimator animator = ValueAnimator.ofInt(start, end);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator arg0) {
                int value = (int) arg0.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
                layoutParams.height = value;
                v.setLayoutParams(layoutParams);
            }
        });
        if (mDuration > 0) {
            animator.setDuration(mDuration);
        }
        return animator;
    }
}