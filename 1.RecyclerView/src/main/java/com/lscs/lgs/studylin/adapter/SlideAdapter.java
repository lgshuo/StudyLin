package com.lscs.lgs.studylin.adapter;

import com.lscs.lgs.basemodule.adapter.BaseQuickAdapter;
import com.lscs.lgs.basemodule.adapter.BaseViewHolder;
import com.lscs.lgs.studylin.R;
import com.lscs.lgs.studylin.bean.SlideBean;

import java.util.List;

public class SlideAdapter extends BaseQuickAdapter<SlideBean,BaseViewHolder> {
    public SlideAdapter(int res, List<SlideBean> list) {
        super(res, list);
    }

    @Override
    protected void convert(BaseViewHolder holder, SlideBean slideBean, int position) {
        holder.setImageResource(R.id.img_bg, slideBean.getImgRes());
        holder.setText(R.id.tv_title, slideBean.getContent());
    }
}
