package com.example.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2018/8/12.
 */

public class ParamsMoveView extends View {
    private int lastX;
    private int lastY;

    public ParamsMoveView(Context context) {
        this(context,null);
    }

    public ParamsMoveView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ParamsMoveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算移动的距离
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                //对left和right进行偏移
                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) getLayoutParams();
                params.leftMargin = offsetX + getLeft()-getWidth()/2;
                params.topMargin = offsetY + getTop()-getHeight();
                setLayoutParams(params);
                break;
        }
        return true;
    }
}
