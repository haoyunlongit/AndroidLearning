package com.example.duokan;

import com.example.duokan.base.DkShelfFetcher;

import java.util.LinkedList;
import java.util.List;

public class DemoShelfFetcher implements DkShelfFetcher<DemoShelfBaseItem> {

    @Override
    public List<DemoShelfBaseItem> fetchBookItem(int count) {
        List<DemoShelfBaseItem> result = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            DemoShelfBaseItem item = new DemoShelfBaseItem();
            result.add(item);
        }

        return result;
    }
}
