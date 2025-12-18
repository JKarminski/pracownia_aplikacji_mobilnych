package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText4 = findViewById(R.id.editTextText2);
        Button button5 = findViewById(R.id.button2);

        button5.setOnClickListener(v -> {
            String text = editText4.getText().toString();
            Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
        });
    }

    public void copyText(View view) {
        EditText editText1 = findViewById(R.id.editTextText);
        android.widget.TextView textView = findViewById(R.id.textView);
        String text = editText1.getText().toString();
        textView.setText(text);
    }
}
