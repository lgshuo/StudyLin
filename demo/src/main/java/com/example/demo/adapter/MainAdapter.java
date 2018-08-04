package com.example.demo.adapter;

import android.content.Intent;
import android.view.View;

import com.example.demo.R;
import com.example.demo.bean.ListDataBean;
import com.lscs.lgs.basemodule.adapter.BaseQuickAdapter;
import com.lscs.lgs.basemodule.adapter.BaseViewHolder;

import java.util.List;

public class MainAdapter extends BaseQuickAdapter<ListDataBean,BaseViewHolder> {
    public MainAdapter(int res, List<ListDataBean> list) {
        super(res, list);
    }

    @Override
    protected void convert(BaseViewHolder holder, final ListDataBean listDataBean, int position) {
        holder.setText(R.id.text, listDataBean.getName());
        View view = holder.getView(R.id.text);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext,listDataBean.getClazz()));
            }
        });
    }
}
