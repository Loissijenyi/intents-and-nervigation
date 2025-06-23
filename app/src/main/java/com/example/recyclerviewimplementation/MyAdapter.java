package com.example.recyclerviewimplementation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<String> dataList;

    public MyAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This is where you inflate the individual item layout (activity_list_item_layout.xml)
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_list_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Bind the data to the views within each list item
        String item = dataList.get(position);
        holder.titleTextView.setText(item);
        // Assuming your item layout has another TextView with ID 'item_description'
        // holder.descriptionTextView.setText("Description for " + item);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    // ViewHolder class to hold references to the views in each list item
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        // public TextView descriptionTextView; // If you have more views in your item layout

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize your views from activity_list_item_layout.xml here
            titleTextView = itemView.findViewById(R.id.item_title);
            // descriptionTextView = itemView.findViewById(R.id.item_description);
        }
    }
}
