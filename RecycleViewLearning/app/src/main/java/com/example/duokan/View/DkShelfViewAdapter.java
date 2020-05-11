package com.example.duokan.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.duokan.base.DkShelfBaseItem;
import com.example.duokan.base.DkShelfDelegateFactory;
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate;
import com.hannesdorfmann.adapterdelegates4.paging.PagedListDelegationAdapter;

import java.util.LinkedList;
import java.util.List;

import static com.example.duokan.View.ShelfLayoutType.LIST;

public class DkShelfViewAdapter extends PagedListDelegationAdapter {
    final private DkShelfDelegateFactory mFactory;
    private List<AdapterDelegate<List<DkShelfBaseItem>>> mDelegates = new LinkedList<>();

    public DkShelfViewAdapter(DkShelfDelegateFactory factory) {
        super(DIFF_CALLBACK);
        mFactory = factory;
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    public void setupAdapterDelegate(final ShelfLayoutType type) {
        for (AdapterDelegate delegate : mDelegates) {
            delegatesManager.removeDelegate(delegate);
        }

        if (type == LIST) {
            mDelegates = mFactory.createListAdapterDelegates();
        } else {
            mDelegates = mFactory.createGirdAdapterDelegates();
        }
        for (AdapterDelegate delegate : mDelegates) {
            delegatesManager.addDelegate(delegate);
        }
    }

    private static final DiffUtil.ItemCallback<DkShelfBaseItem> DIFF_CALLBACK = new DiffUtil.ItemCallback<DkShelfBaseItem>() {
        @Override
        public boolean areItemsTheSame(DkShelfBaseItem oldItem, DkShelfBaseItem newItem) {
            return oldItem.areItemsTheSame(newItem);
        }

        @Override
        public boolean areContentsTheSame(DkShelfBaseItem oldItem, DkShelfBaseItem newItem) {
            return oldItem.areContentsTheSame(newItem);
        }
    };
}
