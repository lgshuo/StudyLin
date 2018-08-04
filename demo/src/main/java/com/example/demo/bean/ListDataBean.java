package com.example.demo.bean;

import com.lscs.lgs.basemodule.base.BaseActivity;

import java.lang.reflect.AccessibleObject;

public class ListDataBean {
    private String name;

    public ListDataBean(String name, Class<? extends BaseActivity> clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<? extends BaseActivity> getClazz() {
        return clazz;
    }

    public void setClazz(Class<BaseActivity> clazz) {
        this.clazz = clazz;
    }

    private Class<? extends BaseActivity> clazz;
}
