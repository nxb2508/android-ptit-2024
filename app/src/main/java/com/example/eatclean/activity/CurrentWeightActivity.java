package com.example.eatclean.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.eatclean.R;

public class CurrentWeightActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView imgClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_weight);
        initApp();
        imgClose.setOnClickListener(this);
    }

    private void initApp() {
        imgClose = findViewById(R.id.imgClose);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.imgClose):
                finish();
                break;
        }
    }
}