package com.lscs.lgs.studylin.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lscs.lgs.studylin.R;
import com.lscs.lgs.studylin.bean.MainListBean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/24/024.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {
    private Context mContext;
    private List<MainListBean> mList;

    public MainAdapter(Context context, List<MainListBean> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MainHolder mainHolder = new MainHolder(LayoutInflater.from(mContext).inflate(R.layout.item_recycler_main, parent, false));
        return mainHolder;
    }

    @Override
    public void onBindViewHolder(MainHolder holder, final int position) {
        holder.tv.setText(mList.get(position).getButtonName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext,mList.get(position).getActivity()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MainHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public MainHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.button);
        }
    }
}
