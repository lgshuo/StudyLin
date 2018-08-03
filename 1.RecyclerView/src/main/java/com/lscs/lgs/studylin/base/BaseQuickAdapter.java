package com.lscs.lgs.studylin.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24/024.
 */

public abstract class BaseQuickAdapter<T, K extends BaseViewHolder> extends RecyclerView.Adapter<K> {
    private List<T> mData;
    private int mLayoutResId;
    protected Context mContext;
    private LayoutInflater mLayoutInflater;

    public BaseQuickAdapter(@LayoutRes int res, List<T> list) {
        this.mData = list == null ? new ArrayList<T>() : list;
        if (res != 0) {
            this.mLayoutResId = res;
        }
    }

    @NonNull
    @Override
    public K onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.mContext = parent.getContext();
        this.mLayoutInflater = LayoutInflater.from(mContext);
        K baseViewHolder = oncreateDefViewHolder(parent, viewType);
        baseViewHolder.setAdapter(this);
        return baseViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull K holder, int position) {
        convert(holder, mData.get(position), position);
    }
    @Override
    public int getItemCount() {
        return mData.size();
    }
    private K oncreateDefViewHolder(ViewGroup parent, int viewType) {
        int layoutId = mLayoutResId;
        return createBaseViewHolder(getItemView(layoutId, parent));
    }

    private K createBaseViewHolder(View itemView) {
        Class temp = getClass();
        Class z = null;
        while (z == null && temp != null) {
            z = getInstancedGenericKClass(temp);        //获取泛型对应的class对象
            temp = temp.getSuperclass();
        }
        K k = createGenericKInstance(z, itemView);
        return k != null ? k : (K) new BaseViewHolder(itemView);
    }

    /**
     * 通过反射获取泛型对象
     * @param z
     * @param view
     * @return
     */
    private K createGenericKInstance(Class z, View view) {
        try {
            Constructor constructor;
            if (z.isMemberClass() && !Modifier.isStatic(z.getModifiers())) {
                constructor = z.getDeclaredConstructor(getClass(), View.class);
                constructor.setAccessible(true);
                return (K) constructor.newInstance(this, view);
            } else {
                constructor = z.getDeclaredConstructor(View.class);
                constructor.setAccessible(true);
                return (K) constructor.newInstance(view);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取viewHolder的泛型类对应的class对象
     * @param z
     * @return
     */
    private Class getInstancedGenericKClass(Class z) {
        Type type = z.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] types = ((ParameterizedType) type).getActualTypeArguments();
            for (Type temp : types) {
                if (temp instanceof Class) {
                    Class tempClass = (Class) temp;
                    if (BaseViewHolder.class.isAssignableFrom(tempClass)) {
                        return tempClass;
                    }
                }
            }
        }
        return null;
    }

    private View getItemView(int layoutId, ViewGroup parent) {
        return mLayoutInflater.inflate(layoutId, parent, false);
    }


    protected abstract void convert(K holder, T t, int position);

}
