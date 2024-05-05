package com.priti.productcomparison;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    private Context context;
    private List<Product> favoriteProducts;
    private OnItemClickListener listener;

    public FavoriteAdapter(Context context, List<Product> favoriteProducts) {
        this.context = context;
        this.favoriteProducts = favoriteProducts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = favoriteProducts.get(position);
        holder.textViewFavoriteName.setText(product.getName());
        // Load image using Glide library
        Glide.with(context)
                .load(product.getImageUrl())
                .placeholder(R.drawable.product_placeholder)
                .error(R.drawable.product_placeholder)
                .into(holder.imageViewFavorite);
        // Add other views for displaying product details
    }

    @Override
    public int getItemCount() {
        return favoriteProducts.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewFavorite;
        TextView textViewFavoriteName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewFavorite = itemView.findViewById(R.id.imageViewFavorite);
            textViewFavoriteName = itemView.findViewById(R.id.textViewFavoriteName);
            // Add other views for displaying product details
        }
    }
}