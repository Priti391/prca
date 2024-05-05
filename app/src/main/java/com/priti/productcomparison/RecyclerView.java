package com.priti.productcomparison;

import androidx.recyclerview.widget.LinearLayoutManager;

public class RecyclerView {

    private RecentlyViewedAdapter adapter;
    private LinearLayoutManager layoutManager;

    public void setAdapter(RecentlyViewedAdapter adapter) {
        this.adapter = adapter;
    }

    public RecentlyViewedAdapter getAdapter() {
        return adapter;
    }

    public void setLayoutManager(LinearLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    public LinearLayoutManager getLayoutManager() {
        return layoutManager;
    }
}
