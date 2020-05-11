package com.example.duokan.base;

import androidx.annotation.WorkerThread;

import java.util.List;

public interface DkShelfFetcher<T extends DkShelfBaseItem> {

    @WorkerThread
    List<T> fetchBookItem(final int count);

}
