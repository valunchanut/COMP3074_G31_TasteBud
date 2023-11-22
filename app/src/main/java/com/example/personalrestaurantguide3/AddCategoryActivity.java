package com.example.personalrestaurantguide3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddCategoryActivity extends AppCompatActivity {

    // there might be category share and category details added later in the logic
    private EditText categoryEditText;
    private Button saveCategoryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        categoryEditText = findViewById(R.id.categoryEditText);
        saveCategoryButton = findViewById(R.id.saveCategoryButton);

        saveCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String categoryName = categoryEditText.getText().toString().trim();
                if (!categoryName.isEmpty()) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("CATEGORY_NAME", categoryName);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                } else {
                    categoryEditText.setError("Please enter a category name");
                }
            }
        });
    }
}
