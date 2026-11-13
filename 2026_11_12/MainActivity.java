package egzamin.inf04.a2026_11_12;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.security.DrbgParameters;

public class MainActivity extends AppCompatActivity {

    int RedInt = 255;
    int GreenInt = 255;
    int BlueInt = 255;

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

        View PodgladV = findViewById(R.id.PodgladV);

        SeekBar ColorRSB = findViewById(R.id.ColorRSB);
        SeekBar ColorGSB = findViewById(R.id.ColorGSB);
        SeekBar ColorBSB = findViewById(R.id.ColorBSB);

        Button PobierzBtn = findViewById(R.id.PobierzBtn);
        TextView WynikTV = findViewById(R.id.WynikTV);

        TextView ValueRTV = findViewById(R.id.ValueRTV);
        TextView ValueGTV = findViewById(R.id.ValueGTV);
        TextView ValueBTV = findViewById(R.id.ValueBTV);

        ColorRSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                RedInt = progress;
                // Tak chcialo mi sie recznie przesuwac bity (swoja droga wychodzi to poza zakres inta co lekko utrudnialo zadanie)
                PodgladV.setBackgroundColor(255*256*256*256 + RedInt*256*256 + GreenInt*256 + BlueInt);
                String RedString = " " + RedInt + " ";
                ValueRTV.setText(RedString);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ColorGSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                GreenInt = progress;
                PodgladV.setBackgroundColor(255*256*256*256 + RedInt*256*256 + GreenInt*256 + BlueInt);
                String GreenString = " " + GreenInt + " ";
                ValueGTV.setText(GreenString);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ColorBSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                BlueInt = progress;
                PodgladV.setBackgroundColor(255*256*256*256 + RedInt*256*256 + GreenInt*256 + BlueInt);
                String BlueString = " " + BlueInt + " ";
                ValueBTV.setText(BlueString);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        PobierzBtn.setOnClickListener(v -> {
            WynikTV.setBackgroundColor(255*256*256*256 + RedInt*256*256 + GreenInt*256 + BlueInt);
            WynikTV.setText(RedInt + ", " + GreenInt + ", " + BlueInt);
        });

    }
}