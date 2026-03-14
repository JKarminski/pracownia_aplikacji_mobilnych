package com.example.a2026_02_09;
import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class ReportedActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reportedactivity);

        TextView nameTv = findViewById(R.id.reported_name);
        TextView surnameTv = findViewById(R.id.reported_surname);
        TextView classTv = findViewById(R.id.reported_class);

        String name = getIntent().getStringExtra("reported_name");
        String surname = getIntent().getStringExtra("reported_surname");
        String className = getIntent().getStringExtra("reported_class");


        if (name != null) nameTv.setText(name);
        if (surname != null) surnameTv.setText(surname);
        if (className != null) classTv.setText(className);


        Button saveNoteButton = findViewById(R.id.save_note_button);
        saveNoteButton.setOnClickListener(v -> {
            finish();
        });


    }
}
