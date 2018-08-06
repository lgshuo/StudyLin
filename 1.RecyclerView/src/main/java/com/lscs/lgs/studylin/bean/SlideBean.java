package com.lscs.lgs.studylin.bean;

public class SlideBean {
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public SlideBean(String content, int imgRes) {
        this.content = content;
        this.imgRes = imgRes;
    }

    private String content;
    private int imgRes;

}
