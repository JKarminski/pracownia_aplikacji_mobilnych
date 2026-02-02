package com.example.a2026_02_02;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    private TextView tvLabelEmail;
    private TextView tvLabelFirst;
    private TextView tvLabelLast;
    private Button btnBack;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tvLabelEmail = view.findViewById(R.id.tv_label_email);
        tvLabelFirst = view.findViewById(R.id.tv_label_first);
        tvLabelLast = view.findViewById(R.id.tv_label_last);
        btnBack = view.findViewById(R.id.btn_back);

        Bundle args = getArguments();
        if (args != null) {
            String email = args.getString("email", "");
            String first = args.getString("first", "");
            String last = args.getString("last", "");

            tvLabelEmail.setText("E-mail: " + email);
            tvLabelFirst.setText("Imie: " + first);
            tvLabelLast.setText("Nazwisko: " + last);
        }

        btnBack.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());
    }
}
