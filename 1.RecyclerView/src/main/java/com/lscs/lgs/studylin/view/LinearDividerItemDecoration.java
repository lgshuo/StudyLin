package com.lscs.lgs.studylin.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lscs.lgs.studylin.activity.ExpendVerticalDecorationActivity;

/**
 * Created by Administrator on 2018/5/24/024.
 */

public class LinearDividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = new int[]{
            android.R.attr.listDivider
    };
    public static final int HORIZENTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
    private boolean haveHead;
    private Drawable mDivider;
    private int mOrientation;

    public LinearDividerItemDecoration(Context context, int orientation) {
        this(context, orientation, false);
    }

    public LinearDividerItemDecoration(Context context, int orientation, boolean haveHead) {
        this.haveHead = haveHead;
        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        a.recycle();
        setOrientation(orientation);
    }


    public void setOrientation(int orientation) {
        if (orientation != HORIZENTAL_LIST && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if (mOrientation == VERTICAL_LIST) {
            drawVertical(c, parent);
        } else if (mOrientation == HORIZENTAL_LIST) {
            drawHorizental(c, parent);
        }
    }

    //画横线
    private void drawVertical(Canvas c, RecyclerView parent) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            if (haveHead && i== 0) {
                int top = child.getTop() + params.topMargin;
                int bottom = top + mDivider.getIntrinsicHeight();
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    //画竖线
    private void drawHorizental(Canvas c, RecyclerView parent) {
        int top = parent.getPaddingTop();
        int bottom = parent.getHeight() - parent.getPaddingBottom();
        int childCount = parent.getChildCount();


        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            if (haveHead && i== 0) {
                int left = child.getLeft() + params.leftMargin;
                int right = left + mDivider.getIntrinsicHeight();
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
            int left = child.getRight() + params.rightMargin;
            int right = left + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        if (mOrientation == VERTICAL_LIST) {
            if (itemPosition == 0 && haveHead) {
                outRect.set(0, mDivider.getIntrinsicHeight(), 0, mDivider.getIntrinsicHeight());
            } else {
                outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
            }
        } else if (mOrientation == HORIZENTAL_LIST) {
            if (itemPosition == 0 && haveHead) {
                outRect.set(mDivider.getIntrinsicWidth(), 0, mDivider.getIntrinsicWidth(), 0);
            } else {
                outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
            }
        }
    }
}
