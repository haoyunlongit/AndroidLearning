package com.example.duokan.base;

import com.hannesdorfmann.adapterdelegates4.AdapterDelegate;

import java.util.List;

public abstract class DkShelfDelegateFactory {
    public abstract List<AdapterDelegate<List<DkShelfBaseItem>>> createListAdapterDelegates();

    public abstract List<AdapterDelegate<List<DkShelfBaseItem>>> createGirdAdapterDelegates();
}
