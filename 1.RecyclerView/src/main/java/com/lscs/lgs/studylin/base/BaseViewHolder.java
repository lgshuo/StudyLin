/**
 * Copyright 2013 Joan Zapata
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lscs.lgs.studylin.base;

import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashSet;
import java.util.LinkedHashSet;


/**
 * Created by Administrator on 2018/5/24/024.
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {


    private final SparseArray<View> views;          //view的集合

    public HashSet<Integer> getNestViews() {
        return nestViews;
    }

    private final HashSet<Integer> nestViews;

    private final LinkedHashSet<Integer> childClickViewIds;

    private final LinkedHashSet<Integer> itemChildLongClickViewIds;
    private BaseQuickAdapter adapter;



    public BaseViewHolder(final View view) {
        super(view);
        this.views = new SparseArray<>();
        this.childClickViewIds = new LinkedHashSet<>();
        this.itemChildLongClickViewIds = new LinkedHashSet<>();
        this.nestViews = new HashSet<>();
    }


    public HashSet<Integer> getItemChildLongClickViewIds() {
        return itemChildLongClickViewIds;
    }

    public HashSet<Integer> getChildClickViewIds() {
        return childClickViewIds;
    }

    public BaseViewHolder setText(@IdRes int viewId, CharSequence value) {
        TextView view = getView(viewId);                                                                            //获取view
        view.setText(value);
        return this;
    }

    public BaseViewHolder setText(@IdRes int viewId, @StringRes int strId) {
        TextView view = getView(viewId);
        view.setText(strId);
        return this;
    }
    public BaseViewHolder setImageResource(@IdRes int viewId, @DrawableRes int imageResId) {
        ImageView view = getView(viewId);
        view.setImageResource(imageResId);
        return this;
    }

    public BaseViewHolder setBackgroundColor(@IdRes int viewId, @ColorInt int color) {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    public BaseViewHolder setBackgroundRes(@IdRes int viewId, @DrawableRes int backgroundRes) {
        View view = getView(viewId);
        view.setBackgroundResource(backgroundRes);
        return this;
    }

    public BaseViewHolder setTextColor(@IdRes int viewId, @ColorInt int textColor) {
        TextView view = getView(viewId);
        view.setTextColor(textColor);
        return this;
    }


    public BaseViewHolder setAlpha(@IdRes int viewId, float value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getView(viewId).setAlpha(value);
        } else {
            // Pre-honeycomb hack to set Alpha value
            AlphaAnimation alpha = new AlphaAnimation(value, value);
            alpha.setDuration(0);
            alpha.setFillAfter(true);
            getView(viewId).startAnimation(alpha);
        }
        return this;
    }

    public BaseViewHolder setVisible(@IdRes int viewId, boolean visible) {
        View view = getView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }


    protected BaseViewHolder setAdapter(BaseQuickAdapter adapter) {
        this.adapter = adapter;
        return this;
    }

    /**
     * 获取view
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(@IdRes int viewId) {
        View view = views.get(viewId);                   //如果集合里有就返回集合里的
        if (view == null) {
            view = itemView.findViewById(viewId);       //如果没有根据id返回view然后存入集合中
            views.put(viewId, view);
        }
        return (T) view;
    }

}
