package com.priti.productcomparison;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private EditText searchEditText;
    private Button searchButton;
    private ListView productListView;
    private ProductSearchManager searchManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchEditText = findViewById(R.id.searchEditText);
        searchButton = findViewById(R.id.searchButton);
        productListView = findViewById(R.id.productListView);

        // Initialize the search manager with a ProductService instance
        searchManager = new ProductSearchManager(new ProductService());

        searchButton.setOnClickListener(view -> searchProducts());
    }
    private void searchProducts() {
        String query = searchEditText.getText().toString().trim();
        if (TextUtils.isEmpty(query)) {
            Toast.makeText(this, "Please enter a search query", Toast.LENGTH_SHORT).show();
            return;
        }

        // Call the searchProducts method of the searchManager
        searchManager.searchProducts(query, new ProductSearchListener() {
            @Override
            public void onSearchResults(List<Product> products) {
                // Update the UI with the search results
                ArrayAdapter<Product> adapter = new ArrayAdapter<>(SearchActivity.this, android.R.layout.simple_list_item_1, products);
                productListView.setAdapter(adapter);
            }

            @Override
            public void onSearchError(String errorMessage) {
                Toast.makeText(SearchActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Define the ProductSearchListener interface
    public interface ProductSearchListener {
        void onSearchResults(List<Product> products);
        void onSearchError(String errorMessage);
    }

    // Define the ProductSearchManager class
    public class ProductSearchManager {
        private ProductService productService;

        public ProductSearchManager(ProductService productService) {
            this.productService = productService;
        }

        public void searchProducts(String query, ProductSearchListener listener) {
            productService.searchProducts(query, new ProductService.ProductSearchCallback() {
                @Override
                public void onProductsFound(List<Product> products) {
                    listener.onSearchResults(products);
                }

                @Override
                public void onSearchError(String errorMessage) {
                    listener.onSearchError(errorMessage);
                }
            });
        }
    }

    // Define the ProductService class
    public static class ProductService {
        public interface ProductSearchCallback {
            void onProductsFound(List<Product> products);
            void onSearchError(String errorMessage);
        }

        public void searchProducts(String query, ProductSearchCallback callback) {
            // Implement the logic to search for products based on the query
            // This could involve sending a request to an API or searching a local database
            // For demonstration purposes, let's assume we have a list of products to return
            List<Product> searchResults = performLocalSearch(query);

            if (searchResults != null && !searchResults.isEmpty()) {
                callback.onProductsFound(searchResults);
            } else {
                callback.onSearchError("No products found for the given query");
            }
        }

        private List<Product> performLocalSearch(String query) {
            // Simulated search logic using a local list of products
            // Replace this with actual search logic, such as querying a database
            List<Product> products = new ArrayList<>();
            // Perform search and populate products list
            return products;
        }
    }
}