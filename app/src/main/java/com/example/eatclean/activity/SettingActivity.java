package com.example.eatclean.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.eatclean.R;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgBack;
    RelativeLayout rlTarget, rlRemind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        initApp();
        imgBack.setOnClickListener(this);
        rlTarget.setOnClickListener(this);
        rlRemind.setOnClickListener(this);
    }

    private void initApp(){
        imgBack = findViewById(R.id.imgBack);
        rlTarget = findViewById(R.id.rlTarget);
        rlRemind = findViewById(R.id.rlRemind);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.imgBack):
                finish();
                break;
            case (R.id.rlTarget):
                Intent targetIntent = new Intent(SettingActivity.this, TargetActivity.class);
                startActivity(targetIntent);
                break;
            case (R.id.rlRemind):
                Intent remindIntent = new Intent(SettingActivity.this, RemindActivity.class);
                startActivity(remindIntent);
                break;
        }
    }
}