package egzamin.inf04.a2026_10_15;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    int aktualnaLiczbaPolubien = 0;

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

        Button polubBtn = findViewById(R.id.PolubBtn);
        Button usunBtn = findViewById(R.id.UsunBtn);
        TextView liczbaPolubienTV = findViewById(R.id.LiczbaPolubien);

        polubBtn.setOnClickListener(v -> {
            aktualnaLiczbaPolubien++;
            String liczbaPolubienStr = aktualnaLiczbaPolubien + " polubien";
            liczbaPolubienTV.setText(liczbaPolubienStr);
        });
        usunBtn.setOnClickListener(v -> {
            if (aktualnaLiczbaPolubien > 0) {
                aktualnaLiczbaPolubien--;
                String liczbaPolubienStr = aktualnaLiczbaPolubien + " polubien";
                liczbaPolubienTV.setText(liczbaPolubienStr);
            }
        });

    }
}