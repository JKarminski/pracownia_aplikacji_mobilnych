package egzamin.inf04.a23_09_2026;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    int counter = 1;
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

        String[] powitania = {"Dzien dobry", "Good morning", "Buenos dias"};

        SeekBar RozmiarSB = findViewById(R.id.RozmiarSB);
        TextView CytatTV = findViewById(R.id.CytatTV);
        TextView RozmiarTV = findViewById(R.id.RozmiarTV);
        Button CytatBtn = findViewById(R.id.CytatBtn);

        RozmiarSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                CytatTV.setTextSize(progress);
                RozmiarTV.setText("Rozmiar: " + progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        CytatBtn.setOnClickListener(v -> {
            CytatTV.setText(powitania[counter]);
            counter += 1;
            counter %= 3;
        });


    }
}