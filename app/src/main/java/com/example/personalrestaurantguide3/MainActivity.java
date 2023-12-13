package com.example.personalrestaurantguide3;

        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.LinearLayout;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.cardview.widget.CardView;

        import java.util.HashSet;
        import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ADD_CATEGORY = 1;
    private LinearLayout cardContainer;
    private SharedPreferences sharedPreferences;
    private Set<String> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardContainer = findViewById(R.id.cardContainer);
        sharedPreferences = getSharedPreferences("AppPreferences", MODE_PRIVATE);
        categories = sharedPreferences.getStringSet("Categories", new HashSet<>());

        // Load existing categories
        for (String category : categories) {
            addCategoryCard(category);
        }

        findViewById(R.id.addCategoryButton).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddCategoryActivity.class);
            startActivityForResult(intent, REQUEST_CODE_ADD_CATEGORY);
        });

        findViewById(R.id.viewCreditsButton).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AboutMeActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD_CATEGORY && resultCode == RESULT_OK) {
            String categoryName = data.getStringExtra("CATEGORY_NAME");
            addCategoryCard(categoryName);
            saveCategory(categoryName);
        }
    }

    private void addCategoryCard(String categoryName) {
        CardView cardView = new CardView(this);
        cardView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        cardView.setCardBackgroundColor(getResources().getColor(android.R.color.white));
        cardView.setRadius(12);

        cardView.setOnClickListener(view -> {
            // Open CategoryDetailActivity with the category name
            Intent intent = new Intent(MainActivity.this, CategoryDetailActivity.class);
            intent.putExtra("CATEGORY_NAME", categoryName);
            startActivity(intent);
        });

        // Add TextView or other views to display the category name
        TextView textView = new TextView(this);
        textView.setText(categoryName);
        textView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        textView.setPadding(16, 16, 16, 16); // Adjust padding as needed
        cardView.addView(textView);

        cardContainer.addView(cardView);
    }
    private void saveCategory(String categoryName) {
        categories.add(categoryName);
        sharedPreferences.edit().putStringSet("Categories", categories).apply();
    }
}
