package com.example.a2025_12_17;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private EditText etEmail;
    private EditText etPassword;
    private EditText etPasswordRepeat;
    private Button btnSubmit;
    private TextView tvMessage;

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

        if (TextUtils.isEmpty(email) || !email.contains("@")) {
            tvMessage.setText("Nieprawidłowy adres e-mail");
            return;
        }

        if (!pass.equals(passRepeat)) {
            tvMessage.setText("Hasła się różnią");
            return;
        }

        tvMessage.setText("Witaj " + email);
    }
}
