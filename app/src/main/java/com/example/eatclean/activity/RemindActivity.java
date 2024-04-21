package com.example.eatclean.activity;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.example.eatclean.R;
import com.example.eatclean.receiver.AlarmReceiver;

import java.util.Calendar;

public class RemindActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgBack;
    TextView txtBreakfastTime, txtLunchTime, txtDinnerTime;
    SwitchCompat switchBreakfast, switchLunch, switchDinner;

    private static final String CHANNEL_ID = "eat_clean";
    private static final int BREAKFAST_CODE=1;
    private static final int LUNCH_CODE=2;
    private static final int DINNER_CODE=3;

    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remind);
        initApp();
    }

    private void initApp() {
        imgBack = findViewById(R.id.imgBack);
        txtBreakfastTime = findViewById(R.id.txtBreakfastTime);
        txtLunchTime = findViewById(R.id.txtLunchTime);
        txtDinnerTime = findViewById(R.id.txtDinnerTime);
        switchBreakfast = findViewById(R.id.switchBreakfast);
        switchLunch = findViewById(R.id.switchLunch);
        switchDinner = findViewById(R.id.switchDinner);

        //quay lai
        imgBack.setOnClickListener(this);
        txtBreakfastTime.setOnClickListener(this);
        txtLunchTime.setOnClickListener(this);
        txtDinnerTime.setOnClickListener(this);

        switchBreakfast.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setNotificationAlarm(getTargetCalendar(txtBreakfastTime),"breakfast");
                } else {
                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.imgBack):
                finish();
                break;
            case (R.id.txtBreakfastTime):
                setTimeFor(txtBreakfastTime);
                break;
            case (R.id.txtLunchTime):
                setTimeFor(txtLunchTime);
                break;
            case (R.id.txtDinnerTime):
                setTimeFor(txtDinnerTime);
                break;
        }
    }

    private void setTimeFor(TextView textView) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String time = String.format("%02d:%02d", hourOfDay, minute);
                        textView.setText(time);
                    }
                }, hour, minute, true);
        timePickerDialog.show();
        switchBreakfast.setChecked(false);
    }


    @SuppressLint("ScheduleExactAlarm")
    private void setNotificationAlarm(Calendar targetCalendar, String action) {
        Intent intent = new Intent(RemindActivity.this, AlarmReceiver.class);
        intent.setAction(action.trim());
        pendingIntent = PendingIntent.getBroadcast(RemindActivity.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
        System.out.println(action);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        if (alarmManager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, targetCalendar.getTimeInMillis(), pendingIntent);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, targetCalendar.getTimeInMillis(), pendingIntent);
            } else {
                alarmManager.set(AlarmManager.RTC_WAKEUP, targetCalendar.getTimeInMillis(), pendingIntent);
            }
        }
    }

    private Calendar getTargetCalendar(TextView textView) {
        String content = (String) textView.getText();
        String hour = content.substring(0, 2);
        String minute = content.substring(3);
        //
        System.out.println(hour);
        System.out.println(minute);
        //
        Calendar targetCal = Calendar.getInstance();
        targetCal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
        targetCal.set(Calendar.MINUTE, Integer.parseInt(minute));
        if (targetCal.before(Calendar.getInstance())) {
            targetCal.add(Calendar.DATE, 1);
        }
        return targetCal;
    }

}