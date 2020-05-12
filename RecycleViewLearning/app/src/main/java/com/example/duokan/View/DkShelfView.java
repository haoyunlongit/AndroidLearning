package com.example.duokan.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duokan.base.DkShelfViewConfig;
import com.nikhilpanju.recyclerviewenhanced.RecyclerTouchListener;

import java.lang.ref.WeakReference;

import static com.example.duokan.View.ShelfLayoutType.GIRD;
import static com.example.duokan.View.ShelfLayoutType.LIST;

public class DkShelfView extends RecyclerView {
    ShelfLayoutType type = LIST;
    private RecyclerTouchListener mTouchListener = null;

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

    public void setAdapter(@Nullable Adapter adapter) {
        if (adapter instanceof DkShelfViewAdapter) {
            setAdapter((DkShelfViewAdapter)adapter, new DkShelfViewConfig.Builder().build());
        } else {
            super.setAdapter(adapter);
        }
    }

    public void setAdapter(@Nullable DkShelfViewAdapter adapter, DkShelfViewConfig config) {
        ((GridLayoutManager)getLayoutManager()).setSpanCount(config.column);
        ((GridLayoutManager)getLayoutManager()).setInitialPrefetchItemCount(config.pageSize);
        setItemViewCacheSize(config.cacheSize);
        if (config.column == 1) {
            type = LIST;
        } else {
            type = GIRD;
        }
        adapter.setupAdapterDelegate(type);
        super.setAdapter(adapter);
    }

    /**
     * @param listener
     * @param viewIds cell 绑定的id
     */
    public synchronized void setItemClickListener(@NonNull OnItemClickListener listener, Integer... viewIds) {
        if (!(getContext() instanceof Activity)) {
            return;
        }

        if (mTouchListener == null) {
            mTouchListener = new RecyclerTouchListener((Activity) getContext(), this);
            addOnItemTouchListener(mTouchListener);
        }

        if (viewIds.length > 0) {
            mTouchListener.setIndependentViews(viewIds);
        }

        mTouchListener.setClickable(new RecyclerTouchListener.OnRowClickListener() {
            @Override
            public void onRowClicked(int position) {
                listener.onItemClick(DkShelfView.this, position);
            }

            @Override
            public void onIndependentViewClicked(int independentViewID, int position) {
                listener.onItemClick(DkShelfView.this, independentViewID, position);
            }
        });
    }

    public synchronized void setItemLongPressListener(@NonNull OnItemLongPressListener listener) {
        if (!(getContext() instanceof Activity)) {
            return;
        }

        if (mTouchListener == null) {
            mTouchListener = new RecyclerTouchListener((Activity) getContext(), this);
            addOnItemTouchListener(mTouchListener);
        }

        mTouchListener.setLongClickable(false, new RecyclerTouchListener.OnRowLongClickListener() {
            @Override
            public void onRowLongClicked(int position) {
                listener.onItemLongPress(DkShelfView.this, position);
            }
        });
    }

    public ShelfLayoutType getLayoutType() {
        return type;
    }

    public static interface OnItemClickListener {
        /**
         *
         * @param shelfView
         * @param viewId   itemView 子视图绑定的id
         * @param position itemView 的相对位置
         */
        void onItemClick(DkShelfView shelfView, int viewId, int position);

        void onItemClick(DkShelfView shelfView, int position);
    }

    public static interface OnItemLongPressListener {
        /**
         *
         * @param shelfView
         * @param position itemView 的相对位置
         */
        void onItemLongPress(DkShelfView shelfView, int position);
    }

}
