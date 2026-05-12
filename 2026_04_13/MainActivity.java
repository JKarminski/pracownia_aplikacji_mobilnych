package com.example.a2026_04_13;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editName, editEmail;
    private TextView txt1, txt2;
    private Button btnIncrease;

    private int counter = 0;
    private String welcomeText = "";

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

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        btnIncrease = findViewById(R.id.btnIncrease);

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("counter");
            welcomeText = savedInstanceState.getString("welcomeText");

            txt2.setText("Kliknales przycisk " + counter + " razy");
            txt1.setText(welcomeText);
        }

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editName.getText().toString().trim();
                String email = editEmail.getText().toString().trim();

                if (name.isEmpty() || email.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Najpierw uzupelnij swoje dane",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                counter++;
                txt2.setText("Kliknales przycisk " + counter + " razy");

                welcomeText = "Witaj, " + name + "! Twoj adres e-mail to: " + email;
                txt1.setText(welcomeText);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("counter", counter);
        outState.putString("welcomeText", welcomeText);
    }
}
