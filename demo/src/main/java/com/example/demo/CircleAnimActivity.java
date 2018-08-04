package com.example.demo;

import android.content.Intent;
import android.view.View;

import com.example.myutils.anim.CircularAnim;
import com.lscs.lgs.annotationlib.ContentView;
import com.lscs.lgs.basemodule.base.BaseActivity;
@ContentView(R.layout.activity_circle_anim)
public class CircleAnimActivity extends BaseActivity {
    @Override
    protected void initData() {
        final View controllView = findViewById(R.id.iv);
        controllView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CircularAnim.fullActivity(CircleAnimActivity.this,controllView).colorOrImageRes(R.color.colorAccent).go(new CircularAnim.OnAnimationEndListener() {
                    @Override
                    public void onAnimationEnd() {
                        startActivity(new Intent(CircleAnimActivity.this,MainActivity.class));
                    }
                });
            }
        });
    }
}
