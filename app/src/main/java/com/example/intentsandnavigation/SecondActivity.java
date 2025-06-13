package com.example.intentsandnavigation; // Replace with your actual package name

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    Button buttonGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        buttonGoBack.setOnClickListener(v -> {
            // Finish this activity and return to the previous one in the stack
            finish();
        });
    }
}