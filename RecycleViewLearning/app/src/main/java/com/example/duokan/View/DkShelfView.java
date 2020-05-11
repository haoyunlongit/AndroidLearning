package com.example.duokan.View;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duokan.base.DkShelfViewConfig;

import static com.example.duokan.View.ShelfLayoutType.GIRD;
import static com.example.duokan.View.ShelfLayoutType.LIST;

public class DkShelfView extends RecyclerView {
    public DkShelfView(@NonNull Context context) {
        super(context);
        init();
    }

    public DkShelfView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        setLayoutManager(gridLayoutManager);
        setHasFixedSize(true);
        setItemAnimator(null);
    }

    public void setAdapter(@Nullable DkShelfViewAdapter adapter, DkShelfViewConfig config) {
        ((GridLayoutManager)getLayoutManager()).setSpanCount(config.column);
        ((GridLayoutManager)getLayoutManager()).setInitialPrefetchItemCount(config.prefetchCount);
        setItemViewCacheSize(config.cacheSize);
        if (config.column == 1) {
            adapter.setupAdapterDelegate(LIST);
        } else {
            adapter.setupAdapterDelegate(GIRD);
        }
        super.setAdapter(adapter);
    }

    public void setAdapter(@Nullable Adapter adapter) {
        if (adapter instanceof DkShelfViewAdapter) {
            setAdapter((DkShelfViewAdapter)adapter, new DkShelfViewConfig.Builder().build());
        } else {
            super.setAdapter(adapter);
        }
    }

}
