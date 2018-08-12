package com.example.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2018/8/12.
 */

public class OffsetMoveView extends View {
    private int lastX;
    private int lastY;

    public OffsetMoveView(Context context) {
        this(context,null);
    }

    public OffsetMoveView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public OffsetMoveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
                offsetLeftAndRight(offsetX);
                //对top和bottom进行偏移
                offsetTopAndBottom(offsetY);
                break;
        }
        return true;
    }
}
