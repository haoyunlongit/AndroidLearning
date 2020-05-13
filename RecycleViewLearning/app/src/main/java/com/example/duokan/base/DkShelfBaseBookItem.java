package com.example.duokan.base;

import android.text.TextUtils;

public class DkShelfBaseBookItem extends DkShelfBaseItem {
    public String mBookTitle;
    public String mBookUuid = "";
    public String mBookAuthor;
    public String mOnlineCoverUri;
    public String mLocalCoverUri;

    public DkShelfBaseBookItem() {
    }

    @Override
    public boolean areItemsTheSame(DkShelfBaseItem dkShelfBaseItem) {
        if (dkShelfBaseItem instanceof DkShelfBaseBookItem) {
            return false;
        }

        if (this == dkShelfBaseItem) {
            return true;
        }
        return false;
    }

    @Override
    public boolean areContentsTheSame(DkShelfBaseItem dkShelfBaseItem) {
        if (dkShelfBaseItem instanceof DkShelfBaseBookItem) {
            return false;
        }

        DkShelfBaseBookItem tempItem = (DkShelfBaseBookItem)dkShelfBaseItem;
        if (this == dkShelfBaseItem && TextUtils.equals(mBookTitle, tempItem.mBookTitle) && TextUtils.equals(mBookTitle, tempItem.mBookUuid) && TextUtils.equals(mBookTitle, tempItem.mBookAuthor) && TextUtils.equals(mBookTitle, tempItem.mOnlineCoverUri) && TextUtils.equals(mBookTitle, tempItem.mLocalCoverUri)) {
            return true;
        }
        return false;
    }
}
