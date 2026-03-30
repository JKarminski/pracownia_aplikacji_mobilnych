package com.example.a2026_03_23;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.TaskStackBuilder;

public class MainActivity extends AppCompatActivity {
    private static final String HIGH_CHANNEL = "high_channel";
    private static final String LOW_CHANNEL = "low_channel";
    private static final int HIGH_NOTIF_ID = 1;
    private static final int LOW_NOTIF_ID = 2;
    private static final int REQ_POST_NOTIF = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createChannels();

        Button btnHigh = findViewById(R.id.NajwyzszyPriorytet);
        Button btnLow = findViewById(R.id.Przycisk2);

        btnHigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { sendHighPriorityNotification(); }
        });

        btnLow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { sendLowPriorityNotification(); }
        });
    }

    private void createChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager nm = getSystemService(NotificationManager.class);
            if (nm == null) return;

            NotificationChannel high = new NotificationChannel(
                    HIGH_CHANNEL,
                    "Kanał wysoki",
                    NotificationManager.IMPORTANCE_HIGH);
            high.setDescription("Kanał powiadomień wysokiego priorytetu");

            NotificationChannel low = new NotificationChannel(
                    LOW_CHANNEL,
                    "Kanał niski",
                    NotificationManager.IMPORTANCE_LOW);
            low.setDescription("Kanał powiadomień niskiego priorytetu");

            nm.createNotificationChannel(high);
            nm.createNotificationChannel(low);
        }
    }

    private boolean checkNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            return ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                    == PackageManager.PERMISSION_GRANTED;
        }
        return true;
    }

    private void requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.POST_NOTIFICATIONS},
                    REQ_POST_NOTIF);
        }
    }

    private PendingIntent buildPendingIntentWithBackStack(Class<?> targetActivity) {
        Intent targetIntent = new Intent(this, targetActivity);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(targetIntent);

        int flags = PendingIntent.FLAG_UPDATE_CURRENT;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) flags |= PendingIntent.FLAG_IMMUTABLE;

        return stackBuilder.getPendingIntent(0, flags);
    }

    private void sendHighPriorityNotification() {
        if (!checkNotificationPermission()) {
            requestNotificationPermission();
            return;
        }

        PendingIntent pendingIntent = buildPendingIntentWithBackStack(Activity2.class);

        NotificationCompat.Builder b = new NotificationCompat.Builder(this, HIGH_CHANNEL)
                .setSmallIcon(android.R.drawable.ic_dialog_alert)
                .setContentTitle("Powiadomienie wysokiego priorytetu")
                .setContentText("Kliknij, aby otworzyć Activity2")
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        NotificationManagerCompat.from(this).notify(HIGH_NOTIF_ID, b.build());
    }

    private void sendLowPriorityNotification() {
        if (!checkNotificationPermission()) {
            requestNotificationPermission();
            return;
        }

        PendingIntent pendingIntent = buildPendingIntentWithBackStack(Activity3.class);

        NotificationCompat.Builder b = new NotificationCompat.Builder(this, LOW_CHANNEL)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Powiadomienie niskiego priorytetu")
                .setContentText("Kliknij, aby otworzyć Activity3")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat.from(this).notify(LOW_NOTIF_ID, b.build());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQ_POST_NOTIF) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            }
        }
    }
}
