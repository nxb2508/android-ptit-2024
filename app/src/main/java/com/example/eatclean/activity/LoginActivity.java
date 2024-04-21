package com.example.eatclean.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.eatclean.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txtDangKy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initApp();
        txtDangKy.setOnClickListener(this);
    }

    private void initApp() {
        txtDangKy = findViewById(R.id.txtDangKy);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.txtDangKy):
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                finish();
                startActivity(registerIntent);
                break;
        }
    }
}
