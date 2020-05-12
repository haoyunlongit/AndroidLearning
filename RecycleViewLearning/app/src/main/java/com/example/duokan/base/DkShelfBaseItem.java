package com.example.duokan.base;

public abstract class DkShelfBaseItem {
    private boolean mSelected = false;

    public abstract boolean areItemsTheSame(DkShelfBaseItem dkShelfBaseItem);

    public abstract boolean areContentsTheSame(DkShelfBaseItem dkShelfBaseItem);

    public boolean selected() {
        return mSelected;
    }

    public void setSelected(boolean selected) {
        mSelected = selected;
    }
}
