package com.example.eatclean.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.eatclean.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout btnOn, btnOff;
    ImageView imgOn, imgOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        initApp();

    }

    private void initApp() {
        btnOn = findViewById(R.id.btnOn);
        btnOff = findViewById(R.id.btnOff);
        imgOn = findViewById(R.id.radio1);
        imgOff = findViewById(R.id.radio2);
    }


    @Override
    public void onClick(View v) {
        if(v == btnOn){
            String tag = (String) imgOn.getTag();
            if(tag.equals("unchecked")){
                imgOn.setTag("checked");
                imgOn.setImageResource(R.drawable.ic_baseline_radio_button_checked_24);
                imgOn.setImageResource(R.drawable.ic_baseline_radio_button_unchecked_24);
            } else if (tag.equals("checked")) {
                imgOn.setTag("unchecked");
                imgOn.setImageResource(R.drawable.ic_baseline_radio_button_unchecked_24);
                imgOn.setImageResource(R.drawable.ic_baseline_radio_button_checked_24);
            }
        }

    }
}