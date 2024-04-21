package com.example.eatclean.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eatclean.R;

public class ProfileNavActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgSetting;
    TextView txtLogIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_nav);
        initApp();
        imgSetting.setOnClickListener(this);
        txtLogIn.setOnClickListener(this);
    }

    private void initApp(){
        imgSetting = findViewById(R.id.imgSetting);
        txtLogIn = findViewById(R.id.txtLogIn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.imgSetting):
                Intent settingIntent = new Intent(ProfileNavActivity.this, SettingActivity.class);
                startActivity(settingIntent);
                break;
            case(R.id.txtLogIn):
                Intent logInIntent = new Intent(ProfileNavActivity.this, LoginActivity.class);
                startActivity(logInIntent);
                break;
        }
    }
}