package com.example.a2026_04_26;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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
    }

    public void imageDialog1(View view){
        dialogImage dialog1 = dialogImage.newInstance(R.drawable.pizza1);
        dialog1.show(getSupportFragmentManager(), "image_dialog");
    }
    public void imageDialog2(View view){
        dialogImage dialog2 = dialogImage.newInstance(R.drawable.pizza2);
        dialog2.show(getSupportFragmentManager(), "image_dialog");
    }
    public void imageDialog3(View view){
        dialogImage dialog3 = dialogImage.newInstance(R.drawable.pizza3);
        dialog3.show(getSupportFragmentManager(), "image_dialog");
    }
    public void imageDialog4(View view){
        dialogImage dialog4 = dialogImage.newInstance(R.drawable.pizza4);
        dialog4.show(getSupportFragmentManager(), "image_dialog");
    }
    public void imageDialog5(View view){
        dialogImage dialog5 = dialogImage.newInstance(R.drawable.pizza5);
        dialog5.show(getSupportFragmentManager(), "image_dialog");
    }
    public void imageDialog6(View view){
        dialogImage dialog6 = dialogImage.newInstance(R.drawable.pizza6);
        dialog6.show(getSupportFragmentManager(), "image_dialog");
    }
    public void imageDialog7(View view){
        dialogImage dialog7 = dialogImage.newInstance(R.drawable.pizza7);
        dialog7.show(getSupportFragmentManager(), "image_dialog");
    }
    public void imageDialog8(View view){
        dialogImage dialog8 = dialogImage.newInstance(R.drawable.pizza8);
        dialog8.show(getSupportFragmentManager(), "image_dialog");
    }
    public void imageDialog9(View view){
        dialogImage dialog9 = dialogImage.newInstance(R.drawable.pizza9);
        dialog9.show(getSupportFragmentManager(), "image_dialog");
    }
    public void imageDialog10(View view){
        dialogImage dialog10 = dialogImage.newInstance(R.drawable.pizza10);
        dialog10.show(getSupportFragmentManager(), "image_dialog");
    }
    public void imageDialog11(View view){
        dialogImage dialog11 = dialogImage.newInstance(R.drawable.pizza11);
        dialog11.show(getSupportFragmentManager(), "image_dialog");
    }
    public void imageDialog12(View view){
        dialogImage dialog12 = dialogImage.newInstance(R.drawable.pizza12);
        dialog12.show(getSupportFragmentManager(), "image_dialog");
    }
    public void imageDialog13(View view){
        dialogImage dialog13 = dialogImage.newInstance(R.drawable.pizza13);
        dialog13.show(getSupportFragmentManager(), "image_dialog");
    }
    public void imageDialog14(View view){
        dialogImage dialog14 = dialogImage.newInstance(R.drawable.pizza14);
        dialog14.show(getSupportFragmentManager(), "image_dialog");
    }
    public void imageDialog15(View view){
        dialogImage dialog15 = dialogImage.newInstance(R.drawable.pizza15);
        dialog15.show(getSupportFragmentManager(), "image_dialog");
    }


}