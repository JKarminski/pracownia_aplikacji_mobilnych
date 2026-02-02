package com.example.a2025_12_17;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView tvWelcome;
    private TextView tvLoggedAs;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvWelcome = findViewById(R.id.tvWelcome);
        tvLoggedAs = findViewById(R.id.tvLoggedAs);
        btnLogout = findViewById(R.id.btnLogout);

        Intent intent = getIntent();
        String email = intent != null ? intent.getStringExtra("email_extra") : null;

        tvWelcome.setText("Witamy w aplikacji");
        tvLoggedAs.setText("Zalogowano jako " + (email != null ? email : ""));

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(SecondActivity.this, MainActivity.class);
                back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(back);
                finish();
            }
        });
    }
}
