package com.example.eatclean.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.eatclean.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtDangNhap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        initApp();
        txtDangNhap.setOnClickListener(this);
    }

    private void initApp() {
        txtDangNhap = findViewById(R.id.txtDangNhap);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.txtDangNhap):
                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                finish();
                startActivity(loginIntent);
                break;
        }
    }
}
