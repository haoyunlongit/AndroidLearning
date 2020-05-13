package com.example.duokan.model;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;
import com.example.duokan.base.DkShelfBaseItem;
import com.example.duokan.base.DkShelfFetcher;

import java.util.LinkedList;
import java.util.List;

public class ShelfViewModel<T extends DkShelfBaseItem> extends ViewModel {
    static PagedList.Config DEFAULT_CONFIG = new PagedList.Config.Builder()
            //发送给服务器每页取多少数据
            .setPageSize(8)
            //距离底部还有多少条数据时开始预加载
            //PrefetchDistance必须>PageSize,否则可能不触发loadAfter
            .setPrefetchDistance(10)
            .build();

    protected LiveData<PagedList<T>> mShelfItems;
    private ShelfDataSourceFactory mShelfDataSourceFactory;
    private DkShelfFetcher<T> mShelfFetcher;

    public ShelfViewModel(@NonNull final DkShelfFetcher fetcher) {
        mShelfDataSourceFactory = new ShelfDataSourceFactory();
        mShelfFetcher = fetcher;
        mShelfItems = new LivePagedListBuilder(mShelfDataSourceFactory, DEFAULT_CONFIG).build();
    }

    public LiveData<PagedList<T>> getBookItems() {
        return mShelfItems;
    }

    public void setShelfItemSelected(int position) {
        PagedList<T>pagedList = mShelfItems.getValue();
        if (pagedList == null || pagedList.size() <= position) {
            return;
        }

        DkShelfBaseItem baseItem = pagedList.get(position);
        boolean selected = baseItem.selected();
        baseItem.setSelected(!selected);
    }

    public void resetItemsSelectState() {
        PagedList<T> pagedList = mShelfItems.getValue();
        List<T> result = new LinkedList<>();
        if (pagedList == null || pagedList.size() == 0) {
            return;
        }

        for (T item : pagedList) {
            item.setSelected(false);
        }
    }

    public List<T> getSelectedItems() {
        PagedList<T> pagedList = mShelfItems.getValue();
        List<T> result = new LinkedList<>();
        if (pagedList == null || pagedList.size() == 0) {
            return result;
        }

        for (T item : pagedList) {
            if (item.selected()) {
                result.add(item);
            }
        }
        return result;
    }

    private class ShelfDataSourceFactory extends DataSource.Factory {
        @NonNull
        @Override
        public DataSource create() {
            return new ShelfDataSource();
        }
    }

    private class ShelfDataSource extends PageKeyedDataSource<Integer, DkShelfBaseItem> {

        @Override
        public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, DkShelfBaseItem> callback) {
            List<DkShelfBaseItem>list = (List<DkShelfBaseItem>)mShelfFetcher.fetchBookItem(10);
            callback.onResult(list, 0, 0);
        }

        @WorkerThread
        @Override
        public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, DkShelfBaseItem> callback) {

        }

        @WorkerThread
        @Override
        public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, DkShelfBaseItem> callback) {
            List<DkShelfBaseItem>list = (List<DkShelfBaseItem>)mShelfFetcher.fetchBookItem(10);
            callback.onResult(list, 0);
        }
    }
}
