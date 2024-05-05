package com.priti.productcomparison;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Comparison extends AppCompatActivity {

    private RecyclerView comparisonRecyclerView;
    private ComparisonAdapter comparisonAdapter;
    private List<Product> comparedProducts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_comparison);

        // Initialize RecyclerView and adapter
        comparisonRecyclerView = findViewById(R.id.comparisonRecyclerView);
        comparisonAdapter = new ComparisonAdapter(this, comparedProducts);
        comparisonRecyclerView.setAdapter(comparisonAdapter);
        comparisonRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Retrieve product data for comparison
        comparedProducts = fetchComparedProducts();

        // Update adapter with product data
        comparisonAdapter.setProducts(comparedProducts);
        comparisonAdapter.notifyDataSetChanged();
    }

    private List<Product> fetchComparedProducts() {
        // Implement logic to retrieve product data for comparison
        // This could involve fetching data from search results or a local database
        // Return a list of products to be compared
        return null;
    }
}
