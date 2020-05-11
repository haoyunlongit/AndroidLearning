package com.example.duokan.base;

import java.util.AbstractList;
import java.util.LinkedList;

public class DkShelfBaseCategoryItem extends DkShelfBaseItem {
    public String categoryName = "";
    public AbstractList<DkShelfBaseBookItem> bookItems = new LinkedList<DkShelfBaseBookItem>();

    @Override
    public boolean areItemsTheSame(DkShelfBaseItem dkShelfBaseItem) {
        if (dkShelfBaseItem instanceof DkShelfBaseCategoryItem) {
            return false;
        }

        if (this == dkShelfBaseItem) {
            return true;
        }
        return false;
    }

    @Override
    public boolean areContentsTheSame(DkShelfBaseItem dkShelfBaseItem) {
        if (dkShelfBaseItem instanceof DkShelfBaseCategoryItem) {
            return false;
        }

        DkShelfBaseCategoryItem tempItem = (DkShelfBaseCategoryItem)dkShelfBaseItem;
        if (this == dkShelfBaseItem && tempItem.bookItems.equals(tempItem.bookItems)) {
            return true;
        }
        return false;
    }


}
