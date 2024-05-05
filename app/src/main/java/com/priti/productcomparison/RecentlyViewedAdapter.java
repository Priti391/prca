package com.priti.productcomparison;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RecentlyViewedAdapter extends RecyclerView.Adapter<RecentlyViewedAdapter.ViewHolder> {

    private Context context;
    private List<Product> recentlyViewedProducts;
    private OnItemClickListener listener;

    public RecentlyViewedAdapter(Context context, List<Product> recentlyViewedProducts) {
        this.context = context;
        this.recentlyViewedProducts = recentlyViewedProducts;
    }

    public interface OnItemClickListener {
        void onItemClick(Product product);

    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recently_viewed, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = recentlyViewedProducts.get(position);
        holder.bind(product);
    }

    @Override
    public int getItemCount() {
        return recentlyViewedProducts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView productNameTextView;
        private ImageView productImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productNameTextView = itemView.findViewById(R.id.productNameTextView);
            productImageView = itemView.findViewById(R.id.productImageView);

            itemView.setOnClickListener(v -> {
                if (listener != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                    listener.onItemClick(recentlyViewedProducts.get(getAdapterPosition()));
                }
            });
        }

        public void bind(Product product) {
            productNameTextView.setText(product.getName());
            productImageView.setImageResource(product.getImageResId());
        }
    }
}