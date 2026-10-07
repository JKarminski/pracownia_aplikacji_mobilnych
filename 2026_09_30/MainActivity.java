package egzamin.inf04.a2026_09_30;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

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

        EditText nowyElementET = findViewById(R.id.Nowy_element);
        Button dodajBtn = findViewById(R.id.Dodaj);
        ListView listaElementowLV = findViewById(R.id.Lista_elementow);

        ArrayList<String> listaDanych = new ArrayList<>();
        listaDanych.add("Zakupy: chleb, maslo, ser");
        listaDanych.add("Do zrobienia: obiad, umyc podlogi");
        listaDanych.add("Weekend: kino, spacer z psem");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaDanych);
        listaElementowLV.setAdapter(adapter);

        dodajBtn.setOnClickListener(v -> {

            String tekst = nowyElementET.getText().toString().trim();

            if (!tekst.isEmpty()){
                listaDanych.add(tekst);
                adapter.notifyDataSetChanged();
                nowyElementET.setText("");
            }

        });


    }
}