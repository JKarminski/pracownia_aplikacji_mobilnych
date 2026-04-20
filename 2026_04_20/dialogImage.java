package com.example.a2026_04_26;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.fragment.app.DialogFragment;

public class dialogImage extends DialogFragment {

    private static final String ARG_IMAGE = "arg_image";

    public static dialogImage newInstance(int imageResId) {
        dialogImage fragment = new dialogImage();
        Bundle args = new Bundle();
        args.putInt(ARG_IMAGE, imageResId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int imageResId = getArguments().getInt(ARG_IMAGE);

        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(imageResId);
        imageView.setAdjustViewBounds(true);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(imageView);

        return builder.create();
    }
}
