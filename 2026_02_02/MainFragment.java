package com.example.a2026_02_02;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.regex.Pattern;

public class MainFragment extends Fragment {

    private EditText etEmail;
    private EditText etFirstName;
    private EditText etLastName;
    private Button btnNext;
    private TextView tvError;

    private final Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        etEmail = view.findViewById(R.id.et_email);
        etFirstName = view.findViewById(R.id.et_firstname);
        etLastName = view.findViewById(R.id.et_lastname);
        btnNext = view.findViewById(R.id.btn_next);
        tvError = view.findViewById(R.id.tv_error);

        btnNext.setOnClickListener(v -> {
            tvError.setText("");
            String email = etEmail.getText().toString().trim();
            String first = etFirstName.getText().toString().trim();
            String last = etLastName.getText().toString().trim();

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(first) || TextUtils.isEmpty(last)) {
                tvError.setTextColor(getResources().getColor(android.R.color.holo_red_light));
                tvError.setText("Wszystkie pola musza byc wypelnione");
                return;
            }

            if (!emailPattern.matcher(email).matches()) {
                tvError.setTextColor(getResources().getColor(android.R.color.holo_red_light));
                tvError.setText("Nieprawidlowy adres e-mail");
                return;
            }

            Bundle args = new Bundle();
            args.putString("email", email);
            args.putString("first", first);
            args.putString("last", last);

            SecondFragment fragmentTwo = new SecondFragment();
            fragmentTwo.setArguments(args);

            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragmentTwo)
                    .addToBackStack(null)
                    .commit();
        });
    }
}
