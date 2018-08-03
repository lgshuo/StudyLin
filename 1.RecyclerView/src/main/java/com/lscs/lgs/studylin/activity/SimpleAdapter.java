package com.lscs.lgs.studylin.activity;

import com.lscs.lgs.studylin.R;
import com.lscs.lgs.studylin.base.BaseQuickAdapter;
import com.lscs.lgs.studylin.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/5/24/024.
 */

public class SimpleAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public SimpleAdapter(int res, List<String> list) {
        super(res, list);
    }

    @Override
    protected void convert(BaseViewHolder holder, String s, int position) {
        holder.setText(R.id.text, s);
    }
}
