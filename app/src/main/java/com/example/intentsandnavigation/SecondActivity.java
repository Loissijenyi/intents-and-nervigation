package com.example.intentsandnavigation; // Replace with your actual package name

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    Button buttonGoBack; // Declared, but not yet initialized

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 1. Set the content view to link to your layout file
        setContentView(R.layout.activity_second); // Make sure 'activity_second' matches your XML file name

        // 2. Initialize buttonGoBack by finding it in your layout
        buttonGoBack = findViewById(R.id.button_go_back); // Make sure 'button_go_back' matches the ID in your XML

        buttonGoBack.setOnClickListener(v -> {
            // Finish this activity and return to the previous one in the stack
            finish();
        });
    }
}