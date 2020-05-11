package com.example.duokan;


import com.example.duokan.base.DkShelfBaseItem;
import com.example.duokan.base.DkShelfBaseBookItem;

public class DemoShelfBaseItem extends DkShelfBaseBookItem {
    @Override
    public boolean areItemsTheSame(DkShelfBaseItem dkShelfBaseItem) {
        return super.areItemsTheSame(dkShelfBaseItem);
    }

    @Override
    public boolean areContentsTheSame(DkShelfBaseItem dkShelfBaseItem) {
        return super.areContentsTheSame(dkShelfBaseItem);
    }
}
