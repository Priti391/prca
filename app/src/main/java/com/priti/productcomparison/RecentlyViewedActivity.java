package com.priti.productcomparison;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecentlyViewedActivity extends AppCompatActivity {

    private RecyclerView recentlyViewedRecyclerView;
    private RecentlyViewedAdapter recentlyViewedAdapter;
    private List<Product> recentlyViewedProducts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recently_viewed);


        // Initialize RecyclerView
        recentlyViewedRecyclerView = findViewById(R.id.recyclerViewRecentlyViewed);
        recentlyViewedProducts = new ArrayList<>();

        // Populate sample data for recently viewed products
        recentlyViewedProducts.add(new Product("Recently Viewed Product 1", 24.99, "https://example.com/product1.jpg"));
        recentlyViewedProducts.add(new Product("Recently Viewed Product 2", 34.99, "https://example.com/product2.jpg"));
        recentlyViewedProducts.add(new Product("Recently Viewed Product 3", 19.99, "https://example.com/product3.jpg"));

        // Set up RecyclerView and adapter
        recentlyViewedAdapter = new RecentlyViewedAdapter(this, recentlyViewedProducts);
        recentlyViewedRecyclerView.setAdapter(recentlyViewedAdapter);
        recentlyViewedRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    }