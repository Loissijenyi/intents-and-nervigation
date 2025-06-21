package com.example.intentsandnavigation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log; // Good practice for debugging

import com.example.intentsandnavigation.SecondActivity;

public class MainActivity extends AppCompatActivity {

    // Declare your Button variables here, but don't initialize them yet
    private Button buttonToSecondActivity;
    private Button buttonOpenDialer;
    private Button buttonOpenBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Step 1: Set the content view. This inflates your layout.


        // Step 3: Set OnClickListeners only if the buttons were found (good practice).
        if (buttonToSecondActivity != null) {
            buttonToSecondActivity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Example: Navigate to a SecondActivity
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }
            });
        } else {
            Log.e("MainActivity", "button_to_second_activity not found!");
        }

        if (buttonOpenDialer != null) {
            buttonOpenDialer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Example: Open Dialer with a specific number
                    String phoneNumber = "1234567890";
                    Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                    dialIntent.setData(Uri.parse("tel:" + phoneNumber));
                    startActivity(dialIntent);
                }
            });
        } else {
            Log.e("MainActivity", "button_open_dialer not found!");
        }

        if (buttonOpenBrowser != null) {
            buttonOpenBrowser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Example: Open Google in a browser
                    String url = "http://www.google.com";
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse(url));
                    startActivity(browserIntent);
                }
            });
        } else {
            Log.e("MainActivity", "button_open_browser not found!");
        }
    }
}