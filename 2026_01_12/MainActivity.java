package com.example.a2025_12_17;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static final String EMAIL_EXTRA = "email_extra";

    private EditText etEmail;
    private EditText etPassword;
    private EditText etPasswordRepeat;
    private Button btnSubmit;
    private TextView tvMessage;

    private final Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etPasswordRepeat = findViewById(R.id.etPasswordRepeat);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvMessage = findViewById(R.id.tvMessage);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleSubmit();
            }
        });
    }

    private void handleSubmit() {
        String email = etEmail.getText().toString().trim();
        String pass = etPassword.getText().toString();
        String passRepeat = etPasswordRepeat.getText().toString();

        if (TextUtils.isEmpty(email) || !emailPattern.matcher(email).matches()) {
            tvMessage.setTextColor(Color.RED);
            tvMessage.setText("Nieprawidłowy adres e-mail");
            return;
        }

        if (!pass.equals(passRepeat)) {
            tvMessage.setTextColor(Color.RED);
            tvMessage.setText("Hasła się różnią");
            return;
        }

        if (!isPasswordValid(pass)) {
            tvMessage.setTextColor(Color.RED);
            tvMessage.setText("Hasło nie spełnia wymagań");
            return;
        }

        tvMessage.setTextColor(Color.BLACK);
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(EMAIL_EXTRA, email);
        startActivity(intent);
    }

    private boolean isPasswordValid(String p) {
        if (p == null) return false;
        if (p.length() < 8) return false;
        boolean hasDigit = false;
        boolean hasUpper = false;
        boolean hasLower = false;
        for (char c : p.toCharArray()) {
            if (Character.isDigit(c)) hasDigit = true;
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isLowerCase(c)) hasLower = true;
        }
        return hasDigit && hasUpper && hasLower;
    }
}
