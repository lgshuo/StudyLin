package com.example.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.FrameLayout;

import com.example.view.LayoutMoveView;
import com.example.view.OffsetMoveView;
import com.example.view.ParamsMoveView;
import com.example.view.R;

/**
 * Created by Administrator on 2018/8/12.
 */

public class MoveViewActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_view);
        FrameLayout framLayout = findViewById(R.id.fram_layout);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(500, 500);
        params.gravity = Gravity.CENTER;
        String type = getIntent().getStringExtra("type");
        switch (type) {
            case "layout":
                LayoutMoveView layoutMoveView = new LayoutMoveView(this);
                layoutMoveView.setLayoutParams(params);
                layoutMoveView.setBackgroundColor(0xffff0000);
                framLayout.removeAllViews();
                framLayout.addView(layoutMoveView);
                break;
            case "offset":
                OffsetMoveView offsetMoveView = new OffsetMoveView(this);
                offsetMoveView.setLayoutParams(params);
                offsetMoveView.setBackgroundColor(0xffff0000);
                framLayout.removeAllViews();
                framLayout.addView(offsetMoveView);
                break;
            case "params":
                ParamsMoveView paramsMoveView = new ParamsMoveView(this);
                paramsMoveView.setLayoutParams(params);
                paramsMoveView.setBackgroundColor(0xffff0000);
                framLayout.removeAllViews();
                framLayout.addView(paramsMoveView);
                break;
        }

    }

    public static void actionStart(Activity activity, String type){
        Intent intent = new Intent(activity, MoveViewActivity.class);
        intent.putExtra("type", type);
        activity.startActivity(intent);
    }
}
