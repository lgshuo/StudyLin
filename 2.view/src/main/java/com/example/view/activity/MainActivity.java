package com.example.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.view.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.layout_move).setOnClickListener(this);
        findViewById(R.id.offset_move).setOnClickListener(this);
        findViewById(R.id.params_move).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_move:
                MoveViewActivity.actionStart(this,"layout");
                break;
            case R.id.offset_move:
                MoveViewActivity.actionStart(this,"offset");
                break;
            case R.id.params_move:
                MoveViewActivity.actionStart(this, "params");
                break;
        }
    }
}
