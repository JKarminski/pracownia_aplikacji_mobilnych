package com.example.egazminik;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        Button rzutBtn = findViewById(R.id.Rzut);
        ImageView kosc1IV = findViewById(R.id.Kosc1);
        ImageView kosc2IV = findViewById(R.id.Kosc2);
        ImageView kosc3IV = findViewById(R.id.Kosc3);
        ImageView kosc4IV = findViewById(R.id.Kosc4);
        ImageView kosc5IV = findViewById(R.id.Kosc5);




    }
}