package com.example.a2026_02_09;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

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

        EditText nameInput = findViewById(R.id.name_input);
        EditText surnameInput = findViewById(R.id.surname_input);
        EditText classInput = findViewById(R.id.class_input);
        Button saveButton = findViewById(R.id.button);

        saveButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString().trim();
            String surname = surnameInput.getText().toString().trim();
            String className = classInput.getText().toString().trim();



            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(surname) || TextUtils.isEmpty(className)) {
                Toast.makeText(MainActivity.this, "Wypelnij wszystkie pola!", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent = new Intent(MainActivity.this, ReportedActivity.class);
            intent.putExtra("reported_name", name);
            intent.putExtra("reported_surname", surname);
            intent.putExtra("reported_class", className);

            ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Dodaj uwagę...");
            progressDialog.setMessage("Proszę czekać.");
            progressDialog.setCancelable(false);
            progressDialog.show();

            nameInput.setText("");
            surnameInput.setText("");
            classInput.setText("");

            new Handler(Looper.getMainLooper()).postDelayed(()->{
                if(progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
                startActivity(intent);
            }, 2000);

        });
    }
}