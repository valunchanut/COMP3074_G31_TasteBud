package com.example.personalrestaurantguide3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryDetailActivity extends AppCompatActivity {

    private String categoryName;
    private RecyclerView recyclerView;
    // Adapter for the RecyclerView (to be implemented)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);

        categoryName = getIntent().getStringExtra("CATEGORY_NAME");
        recyclerView = findViewById(R.id.rvRestaurants);

        // Set up RecyclerView with an adapter
        // The adapter should handle the display of restaurant items

        findViewById(R.id.btnAddRestaurant).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to open an activity to add a new restaurant
            }
        });

        findViewById(R.id.btnManageRestaurants).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to open an activity or a dialog to manage (add/delete) restaurants
            }
        });

        // Load and display restaurants for this category
    }
}
