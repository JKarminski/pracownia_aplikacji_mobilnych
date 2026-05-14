package com.example.a2026_03_16;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "Weterynarz";
    private static final int NOTIF_ID = 1001;
    private ActivityResultLauncher<String> requestPermissionLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {});

        createNotificationChannel();

        final EditText ownerNameEditText = findViewById(R.id.ownerNameEditText);
        final RadioGroup speciesRadioGroup = findViewById(R.id.speciesRadioGroup);
        final SeekBar ageSeekBar = findViewById(R.id.ageSeekBar);
        final TextView ageValueTextView = findViewById(R.id.ageValueTextView);
        final EditText purposeEditText = findViewById(R.id.purposeEditText);
        final EditText timeEditText = findViewById(R.id.timeEditText);
        final Button okButton = findViewById(R.id.okButton);
        final TextView resultTextView = findViewById(R.id.resultTextView);

        ageSeekBar.setMax(20);
        ageSeekBar.setProgress(0);
        ageValueTextView.setText("0");
        timeEditText.setText("16:00");

        speciesRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            int newMax = 20;
            if (checkedId == R.id.dogRadioButton) {
                newMax = 18;
            } else if (checkedId == R.id.catRadioButton) {
                newMax = 20;
            } else if (checkedId == R.id.guineaPigRadioButton) {
                newMax = 9;
            }
            ageSeekBar.setMax(newMax);
            if (ageSeekBar.getProgress() > newMax) {
                ageSeekBar.setProgress(newMax);
            }
            ageValueTextView.setText(String.valueOf(ageSeekBar.getProgress()));
        });

        ageSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ageValueTextView.setText(String.valueOf(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        timeEditText.setOnClickListener(v -> {
            String currentText = timeEditText.getText().toString();
            int hour = 16;
            int minute = 0;
            try {
                String[] parts = currentText.split(":");
                if (parts.length >= 2) {
                    hour = Integer.parseInt(parts[0]);
                    minute = Integer.parseInt(parts[1]);
                }
            } catch (Exception e) {
                hour = 16;
                minute = 0;
            }
            TimePickerDialog timePicker = new TimePickerDialog(MainActivity.this,
                    (view, selectedHour, selectedMinute) -> {
                        String formatted = String.format(Locale.getDefault(), "%02d:%02d", selectedHour, selectedMinute);
                        timeEditText.setText(formatted);
                    }, hour, minute, true);
            timePicker.show();
        });

        okButton.setOnClickListener(v -> {
            String ownerName = ownerNameEditText.getText().toString().trim();
            if (ownerName.isEmpty()) ownerName = "-";
            int selectedSpeciesId = speciesRadioGroup.getCheckedRadioButtonId();
            String speciesText = "-";
            if (selectedSpeciesId != -1) {
                RadioButton rb = findViewById(selectedSpeciesId);
                speciesText = rb.getText().toString();
            }
            int age = ageSeekBar.getProgress();
            String purpose = purposeEditText.getText().toString().trim();
            if (purpose.isEmpty()) purpose = "-";
            String time = timeEditText.getText().toString().trim();
            if (time.isEmpty()) time = "-";
            String result = ownerName + ", " + speciesText + ", " + age + ", " + purpose + ", " + time;
            resultTextView.setText(result);
            Toast.makeText(MainActivity.this, "Dane zapisane", Toast.LENGTH_SHORT).show();
            ensurePermissionAndNotify(result);
        });
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Weterynarz";
            String description = "Powiadomienia o wizycie";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }
    }

    private void ensurePermissionAndNotify(String content) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS);
                sendNotification(content);
            } else {
                sendNotification(content);
            }
        } else {
            sendNotification(content);
        }
    }

    private void sendNotification(String content) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_MUTABLE);
        } else {
            pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Wizyta u weterynarza")
                .setContentText(content)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(content))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIF_ID, builder.build());
    }
}
