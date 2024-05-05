package com.priti.productcomparison;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Favorite extends AppCompatActivity {

    private RecyclerView favoriteRecyclerView;
    private FavoriteAdapter favoriteAdapter;
    private List<Product> favoriteProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_item);

        favoriteRecyclerView = findViewById(R.id.recyclerViewFavorites);
        favoriteProducts = new ArrayList<>();

        // Assuming you have a list of favorite products, populate the list
        favoriteProducts.add(new Product("Favorite Product 1", 19.99, "https://example.com/product1.jpg"));
        favoriteProducts.add(new Product("Favorite Product 2", 29.99, "https://example.com/product2.jpg"));

        // Initialize and set the adapter for RecyclerView
        favoriteAdapter = new FavoriteAdapter(this, favoriteProducts);
        favoriteRecyclerView.setAdapter(favoriteAdapter);
        favoriteRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Set item click listener for the adapter
        favoriteAdapter.setOnItemClickListener(new FavoriteAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Handle item click here
                Product product = favoriteProducts.get(position);
                // Example: Display a toast message with the name of the clicked product
                Toast.makeText(Favorite.this, "Clicked on: " + product.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}