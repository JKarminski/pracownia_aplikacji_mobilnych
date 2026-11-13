package egzamin.inf04.a2026_10_28;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int ASCIIInt;
    char ASCIIChar;
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

        EditText WartoscET = findViewById(R.id.WartoscET);
        EditText TekstET = findViewById(R.id.TekstET);
        TextView WynikSzyfrowaniaTV = findViewById(R.id.WynikSzyfrowaniaTV);
        Button SzyfrowanieBtn = findViewById(R.id.SzyfrowanieBtn);

        SzyfrowanieBtn.setOnClickListener(v -> {
            String TekstStr = TekstET.getText().toString();
            int dlugoscTekstuInt = TekstStr.length();
            StringBuilder WynikSB = new StringBuilder(TekstStr);
            String WartoscStr = WartoscET.getText().toString();
            int WartoscInt;
            try {
                 WartoscInt = Integer.parseInt(WartoscStr);
            } catch (Exception e) {
                WartoscInt = 0;
            }
            for (int i = 0; i < dlugoscTekstuInt; ++i){
                ASCIIInt = (int) WynikSB.charAt(i);
                ASCIIInt -= 97;
                ASCIIInt += WartoscInt;
                ASCIIInt %= 26;
                ASCIIInt += 97;
                ASCIIChar = (char) ASCIIInt;
                WynikSB.setCharAt(i, ASCIIChar);
            }
            String WynikSzyfrowaniaStr = WynikSB.toString();
            WynikSzyfrowaniaTV.setText(WynikSzyfrowaniaStr);
        });

    }
}