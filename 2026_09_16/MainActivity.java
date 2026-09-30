package egzamin.inf04.a2026_09_16;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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



        Button ZatwierdzBtn = findViewById(R.id.Zatwierdz);
        EditText NumerPraniaET = findViewById(R.id.Numer_prania_input);
        TextView NumerPraniaTV = findViewById(R.id.Numer_prania);

        ZatwierdzBtn.setOnClickListener(v-> {
            String NumerPraniaParseStr = NumerPraniaET.getText().toString();
            int NumerPraniaParseInt = 0;
            if (!NumerPraniaParseStr.isEmpty()) {
                NumerPraniaParseInt = Integer.parseInt(NumerPraniaParseStr);
            }

            if ( NumerPraniaParseInt > 0 && NumerPraniaParseInt < 13 ) {
                String NumerPraniaStr = "Numer prania: " + NumerPraniaET.getText().toString();
                NumerPraniaTV.setText(NumerPraniaStr);
            }
        });

        Button WlaczWylaczBtn = findViewById(R.id.WlaczWylacz);
        TextView OdkurzaczStan = findViewById(R.id.Odkurzacz_stan);

        WlaczWylaczBtn.setOnClickListener(v-> {
            if ( WlaczWylaczBtn.getText().toString().equals("Wlacz")) {
                WlaczWylaczBtn.setText("Wylacz");
                OdkurzaczStan.setText("Odkurzacz wlaczony");
            }
            else {
                WlaczWylaczBtn.setText("Wlacz");
                OdkurzaczStan.setText("Odkurzacz wylaczony");
            }
        });

    }
}