package com.example.eatclean.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.eatclean.R;

public class TargetActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imgBack;
    RelativeLayout rlInitialWeight, rlTargetWeight, rlCurrentWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.target);
        initApp();
        imgBack.setOnClickListener(this);
        rlInitialWeight.setOnClickListener(this);
        rlTargetWeight.setOnClickListener(this);
        rlCurrentWeight.setOnClickListener(this);

    }

    private void initApp() {
        imgBack = findViewById(R.id.imgBack);
        rlInitialWeight = findViewById(R.id.rlInitialWeight);
        rlTargetWeight = findViewById(R.id.rlTargetWeight);
        rlCurrentWeight = findViewById(R.id.rlCurrentWeight);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.imgBack):
                finish();
                break;
            case (R.id.rlInitialWeight):
                Intent initialWeightIntent = new Intent(TargetActivity.this, InitialWeightActivity.class);
                startActivity(initialWeightIntent);
                break;
            case (R.id.rlTargetWeight):
                Intent targetWeightIntent = new Intent(TargetActivity.this, TargetWeightActivity.class);
                startActivity(targetWeightIntent);
                break;
            case (R.id.rlCurrentWeight):
                Intent currentWeightIntent = new Intent(TargetActivity.this, CurrentWeightActivity.class);
                startActivity(currentWeightIntent);
                break;
        }
    }

}