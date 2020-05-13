package com.example.duokan;

import com.example.duokan.base.DkShelfBaseItem;
import com.example.duokan.base.DkShelfDelegateFactory;
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate;

import java.util.LinkedList;
import java.util.List;

public class DemoAdapterDelegateFactory extends DkShelfDelegateFactory {

    @Override
    public List<AdapterDelegate<List<DkShelfBaseItem>>> createListAdapterDelegates() {
        List<AdapterDelegate<List<DkShelfBaseItem>>> list = new LinkedList<AdapterDelegate<List<DkShelfBaseItem>>>();
        DemoShelfListAdapterDelegate delegate = new DemoShelfListAdapterDelegate();
        list.add(delegate);
        return list;
    }

    @Override
    public List<AdapterDelegate<List<DkShelfBaseItem>>> createGirdAdapterDelegates() {
        List<AdapterDelegate<List<DkShelfBaseItem>>> list = new LinkedList<AdapterDelegate<List<DkShelfBaseItem>>>();
        DemoShelfGridAdapterDelegate delegate = new DemoShelfGridAdapterDelegate();
        list.add(delegate);
        return list;
    }
}
