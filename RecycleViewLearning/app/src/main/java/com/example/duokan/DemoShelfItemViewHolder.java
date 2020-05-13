package com.example.duokan;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.duokan.View.ShelfBaseViewHolder;
import com.example.duokan.base.DkShelfBaseItem;
import com.example.shelf.R;

public class DemoShelfItemViewHolder extends ShelfBaseViewHolder {
    public DemoShelfItemViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void onBindView(final DkShelfBaseItem baseItem) {
        TextView mSelectedView = itemView.findViewById(R.id.select_flag);
        if (mSelectedView != null) {
            if (baseItem.selected()) {
                mSelectedView.setText("选中");
            } else {
                mSelectedView.setText("");
            }
        }
    }
}
