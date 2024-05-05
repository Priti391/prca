package com.priti.productcomparison;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ComparisonAdapter extends RecyclerView.Adapter<ComparisonAdapter.ViewHolder> {

    private Context context;
    private List<Product> products;

    public ComparisonAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_comparison, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = products.get(position);
        holder.bind(product);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setProducts(List<Product> comparedProducts) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView productNameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productNameTextView = itemView.findViewById(R.id.productNameTextView);
        }

        public void bind(Product product) {
            productNameTextView.setText(product.getName());
            // Add more bindings for other product details if needed
        }
    }
}