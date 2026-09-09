package egzamin.inf04.kremowe_kosci;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

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

        Random random = new Random();
        
        Button rzutBtn = findViewById(R.id.Rzut);
        ImageView kosc1IV = findViewById(R.id.Kosc1);
        ImageView kosc2IV = findViewById(R.id.Kosc2);
        ImageView kosc3IV = findViewById(R.id.Kosc3);
        ImageView kosc4IV = findViewById(R.id.Kosc4);
        ImageView kosc5IV = findViewById(R.id.Kosc5);

        ImageView[] kosciImageViews = {
            kosc1IV,
            kosc2IV,
            kosc3IV,
            kosc4IV,
            kosc5IV
        };
        int[] kosciInt = {
            R.drawable.k1,
            R.drawable.k2,
            R.drawable.k3,
            R.drawable.k4,
            R.drawable.k5,
            R.drawable.k6
        };

        TextView wynikLosowaniaTV = findViewById(R.id.Wynik_losowania);
        TextView wynikGryTV = findViewById(R.id.Wynik_gry);

        final int[] gameCounter = {0};

        rzutBtn.setOnClickListener(v -> {
            int counter = 0;
            int[] wyniki = new int[5];
            for (int i = 0; i < kosciImageViews.length; i++){
                int number0To5 = random.nextInt(6);
                kosciImageViews[i].setImageResource(kosciInt[number0To5]);
                wyniki[i] += number0To5 + 1;
            }
            int[] zliczanie = new int[7];
            for (int wynik : wyniki) {
                zliczanie[wynik]++;
            }
            for (int i = 1; i < zliczanie.length; i++) {
                if (zliczanie[i] >= 2) {
                    counter += zliczanie[i] * i;
                }
            }
            gameCounter[0] += counter;
            String wynikStr = "Wynik tego losowania: " + counter;
            wynikLosowaniaTV.setText(wynikStr);
            String wynikGryStr = "Wynik gry: " + gameCounter[0];
            wynikGryTV.setText(wynikGryStr);
        });

        Button resetBtn = findViewById(R.id.Resetuj);

        resetBtn.setOnClickListener(v -> {
            wynikLosowaniaTV.setText("Wynik tego losowania: 0");
            wynikGryTV.setText("Wynik gry: 0");
            for (ImageView kosc : kosciImageViews) {
                kosc.setImageResource(R.drawable.question);
            }
        });


    }
}