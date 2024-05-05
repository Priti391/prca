package com.priti.productcomparison;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class product_details extends AppCompatActivity {

    private TextView productNameTextView, productPriceTextView;
    private TextView productFeaturesTextView, productAvailabilityTextView;
    private ImageView productImageView;
    private TextView productReviewsTextView;
    private TextView relatedProductsTextView;
    private Spinner productVariantsSpinner;
    private Button addToCartButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        // Initialize TextViews
        productNameTextView = findViewById(R.id.productNameTextView);
        productPriceTextView = findViewById(R.id.productPriceTextView);
        productFeaturesTextView = findViewById(R.id.productFeaturesTextView);
        productAvailabilityTextView = findViewById(R.id.productAvailabilityTextView);
        productImageView = findViewById(R.id.productImageView);
        addToCartButton = findViewById(R.id.addToCartButton);
        productReviewsTextView = findViewById(R.id.productReviewsTextView);
        relatedProductsTextView = findViewById(R.id.relatedProductsTextView);
        productVariantsSpinner = findViewById(R.id.productVariantsSpinner);

        // Specify Image URL
        String imageUrl = "https://example.com/your_image_url.jpg";
        // Load Image with Glide
        Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.product_placeholder) // Set placeholder image
                .error(R.drawable.product_placeholder) // Set error image (optional)
                .into(productImageView);



        // Get product details from intent or API
        String productName = getIntent().getStringExtra("productName");
        double productPrice = getIntent().getDoubleExtra("productPrice", 0.0);
        String productFeatures = getIntent().getStringExtra("productFeatures");
        String productAvailability = getIntent().getStringExtra("productAvailability");

        // Set product details in TextViews
        productNameTextView.setText(productName);
        productPriceTextView.setText(String.format("$%.2f", productPrice));
        productFeaturesTextView.setText(productFeatures);
        productAvailabilityTextView.setText(productAvailability);

        // Set listener for add to cart button
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform add to cart action
                // For demonstration, display a toast message
                Toast.makeText(product_details.this, "Product added to cart", Toast.LENGTH_SHORT).show();
            }
        });

        // Populate product variants spinner
        List<String> variants = new ArrayList<>();
        variants.add("Variant 1");
        variants.add("Variant 2");
        variants.add("Variant 3");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, variants);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        productVariantsSpinner.setAdapter(spinnerAdapter);

        // Set listener for product variants spinner
        productVariantsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedVariant = (String) parent.getItemAtPosition(position);
                // Perform action based on selected variant
                // For demonstration, display a toast message
                Toast.makeText(product_details.this, "Selected variant: " + selectedVariant, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }
    }