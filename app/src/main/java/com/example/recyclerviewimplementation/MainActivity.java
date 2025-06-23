package com.example.recyclerviewimplementation;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

// It is highly recommended to rename this class to reflect its purpose,
// e.g., MainActivity or MyRecyclerViewActivity, as it hosts the RecyclerView.
public class MainActivity extends AppCompatActivity { // Renamed for clarity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // IMPORTANT: Set the content view to the layout that actually CONTAINS your RecyclerView.
        // This is typically your main activity layout, e.g., activity_main.xml.
        setContentView(R.layout.activity_main); // <--- THIS IS THE CRITICAL CORRECTION

        // Now, findViewById(R.id.my_recycler_view) should correctly find the RecyclerView
        // if it exists in activity_main.xml
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);

        // Check if the RecyclerView was found before proceeding
        if (recyclerView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(recyclerView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });

            // --- Basic RecyclerView Setup (Add these if you haven't already) ---
            // 1. Create a list of data
            List<String> dataList = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                dataList.add("Item " + (i + 1));
            }

            // 2. Create an Adapter (you'll need to define MyAdapter and MyViewHolder)
            // For this example, we'll assume MyAdapter takes a List<String>
            MyAdapter adapter = new MyAdapter(dataList);

            // 3. Set the Adapter and LayoutManager
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

        } else {
            // Log an error or show a message if the RecyclerView is still null,
            // which would indicate a problem with the layout ID or XML file.
            System.err.println("Error: RecyclerView with ID 'my_recycler_view' not found in layout 'activity_main.xml'");
        }
    }
}
