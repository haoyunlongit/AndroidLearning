package com.example.duokan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import android.os.Bundle;
import android.view.View;

import com.example.duokan.View.DkShelfViewAdapter;
import com.example.duokan.base.DkShelfViewConfig;
import com.example.shelf.R;
import com.example.duokan.View.DkShelfView;
import com.example.duokan.base.DkShelfBaseItem;
import com.example.duokan.model.ShelfViewModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class MainActivity extends AppCompatActivity {
    private SmartRefreshLayout mRefreshLayout;
    protected DkShelfView mStoreFeed;
    private DkShelfViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStoreFeed = (DkShelfView) findViewById(R.id.store_feed);

        mAdapter = new DkShelfViewAdapter(new DemoAdapterDelegateFactory());
        DkShelfViewConfig shelfViewConfig = new DkShelfViewConfig.Builder().prefetchCount(5).cacheSize(5).build();
        mStoreFeed.setAdapter(mAdapter, shelfViewConfig);

        ShelfViewModel model = new ShelfViewModel(new DemoShelfFetcher());
        LiveData<PagedList<DkShelfBaseItem>> listLiveData = model.getBookItems();
        listLiveData.observe(this, new Observer<PagedList<DkShelfBaseItem>>() {
            @Override
            public void onChanged(PagedList<DkShelfBaseItem> dkShelfBaseItems) {
                mAdapter.submitList(dkShelfBaseItems);
            }
        });

        findViewById(R.id.title_template).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DkShelfViewConfig shelfViewConfig = new DkShelfViewConfig.Builder().prefetchCount(5).cacheSize(5).column(3).build();
                mStoreFeed.setAdapter(mAdapter, shelfViewConfig);
                mAdapter.notifyDataSetChanged();
            }
        });
    }
}
