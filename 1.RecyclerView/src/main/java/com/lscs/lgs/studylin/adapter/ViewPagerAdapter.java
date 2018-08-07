package com.lscs.lgs.studylin.adapter;

import com.lscs.lgs.basemodule.adapter.BaseQuickAdapter;
import com.lscs.lgs.basemodule.adapter.BaseViewHolder;
import com.lscs.lgs.studylin.R;

import java.util.List;

public class ViewPagerAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public ViewPagerAdapter(int res, List<String> list) {
        super(res, list);
    }

    @Override
    protected void convert(BaseViewHolder holder, String s, int position) {
        holder.setText(R.id.pager, s);
    }
}
