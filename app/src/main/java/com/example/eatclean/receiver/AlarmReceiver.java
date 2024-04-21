package com.example.eatclean.receiver;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.example.eatclean.R;
import com.example.eatclean.activity.SettingActivity;

import java.util.Date;

public class AlarmReceiver extends BroadcastReceiver {

    final String CHANNEL_ID = "breakfast";

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("accessed");
        if (intent.getAction().equals("breakfast")) {
            System.out.println("accessed");
            Intent notificationIntent = new Intent(context, SettingActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Alarm Notification")
                    .setContentText("123456")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

            // Tạo kênh thông báo (chỉ cần làm một lần)
            createNotificationChannel(context);

            // Hiển thị thông báo
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            if (notificationManager != null) {
                notificationManager.notify(getNotificationId(), builder.build());
            }
        }
    }

    private void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Alarm Channel";
            String description = "Channel for alarm notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private int getNotificationId() {
        Date date = new Date();
        return (int) date.getTime();
    }
}
