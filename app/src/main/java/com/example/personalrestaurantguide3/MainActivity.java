package com.example.personalrestaurantguide3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ADD_CATEGORY = 1; // Unique request code for adding a category
    private LinearLayout cardContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Static category cards
        CardView italianCard = findViewById(R.id.c1);
        CardView frenchCard = findViewById(R.id.c2);

        // OnClickListener for Italian category
        italianCard.setOnClickListener(view -> {
            // Replace ListView1.class with the actual Activity class you want to open
            Intent intent = new Intent(MainActivity.this, ListView1.class);
            startActivity(intent);
        });

        // OnClickListener for French category
        frenchCard.setOnClickListener(view -> {
            // Replace ListView2.class with the actual Activity class you want to open
            Intent intent = new Intent(MainActivity.this, ListView2.class);
            startActivity(intent);
        });

        // Container for dynamically added categories
        cardContainer = findViewById(R.id.cardContainer);

        // Button to add new categories
        findViewById(R.id.addCategoryButton).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddCategoryActivity.class);
            startActivityForResult(intent, REQUEST_CODE_ADD_CATEGORY);
        });

        // Button for viewing credits
        findViewById(R.id.viewCreditsButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutMeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD_CATEGORY && resultCode == RESULT_OK) {
            String categoryName = data.getStringExtra("CATEGORY_NAME");
            addCategoryCard(categoryName);
        }
    }

    // Method to dynamically add a new category card
    private void addCategoryCard(String categoryName) {
        CardView cardView = new CardView(this);
        cardView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        cardView.setCardBackgroundColor(getResources().getColor(android.R.color.white));
        cardView.setRadius(12);

        cardView.setOnClickListener(view -> {
            // Replace with logic to open the category detail view
            // Intent intent = new Intent(MainActivity.this, CategoryDetailActivity.class);
            // intent.putExtra("CATEGORY_NAME", categoryName);
            // startActivity(intent);
        });

        // Add TextView or other views to display the category name
        // ...

        cardContainer.addView(cardView);
    }
}