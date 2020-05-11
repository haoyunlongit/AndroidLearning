package com.example.duokan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duokan.View.ShelfBaseViewHolder;
import com.example.duokan.base.DkShelfBaseItem;
import com.example.shelf.R;
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate;

import java.util.List;

public class DemoShelfGridAdapterDelegate extends AdapterDelegate<List<DkShelfBaseItem>> {
    @Override
    protected boolean isForViewType(@NonNull List<DkShelfBaseItem> items, int position) {
        return true;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        View tempView = LayoutInflater.from(parent.getContext()).inflate(R.layout.shelf__gird_cell, parent, false);
        return new ShelfBaseViewHolder(tempView);
    }

    @Override
    protected void onBindViewHolder(@NonNull List<DkShelfBaseItem> items, int position, @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {

    }
}
