package egzamin.inf04.a2026_10_21;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText ownerNameEditText = findViewById(R.id.ownerNameEditText);
        RadioGroup speciesRadioGroup = findViewById(R.id.speciesRadioGroup);
        SeekBar ageSeekBar = findViewById(R.id.ageSeekBar);
        TextView ageValueTextView = findViewById(R.id.ageValueTextView);
        EditText purposeEditText = findViewById(R.id.purposeEditText);
        EditText timeEditText = findViewById(R.id.timeEditText);
        Button okButton = findViewById(R.id.okButton);
        TextView resultTextView = findViewById(R.id.resultTextView);

        ageValueTextView.setText("0");

        speciesRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            int maxAge = 20;
            if (checkedId == R.id.dogRadioButton) maxAge = 18;
            else if (checkedId == R.id.guineaPigRadioButton) maxAge = 9;

            ageSeekBar.setMax(maxAge);

            if (ageSeekBar.getProgress() > maxAge) {
                ageSeekBar.setProgress(maxAge);
            }
            ageValueTextView.setText(String.valueOf(ageSeekBar.getProgress()));
        });

        ageSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ageValueTextView.setText(String.valueOf(progress));
            }
            public void onStartTrackingTouch(SeekBar seekBar) {}
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        okButton.setOnClickListener(v -> {
            String name = ownerNameEditText.getText().toString().trim();
            String purpose = purposeEditText.getText().toString().trim();
            String time = timeEditText.getText().toString().trim();
            int age = ageSeekBar.getProgress();

            int selectedId = speciesRadioGroup.getCheckedRadioButtonId();
            String species = "-";
            if (selectedId != -1) {
                RadioButton rb = findViewById(selectedId);
                species = rb.getText().toString();
            }

            String result = name + ", " + species + ", " + age + ", " + purpose + ", " + time;
            resultTextView.setText(result);
        });
    }
}
