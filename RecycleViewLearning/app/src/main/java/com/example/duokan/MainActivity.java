package com.example.duokan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.example.duokan.View.DkShelfViewAdapter;
import com.example.duokan.View.ShelfLayoutType;
import com.example.duokan.base.DkShelfViewConfig;
import com.example.shelf.R;
import com.example.duokan.View.DkShelfView;
import com.example.duokan.base.DkShelfBaseItem;
import com.example.duokan.model.ShelfViewModel;
import com.nikhilpanju.recyclerviewenhanced.RecyclerTouchListener;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    protected DkShelfView mStoreFeed;

    private DkShelfViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mStoreFeed = (DkShelfView) findViewById(R.id.store_feed);
        mAdapter = new DkShelfViewAdapter(new DemoAdapterDelegateFactory());
        DkShelfViewConfig shelfViewConfig = new DkShelfViewConfig.Builder().pageSize(5).cacheSize(5).build();
        mStoreFeed.setAdapter(mAdapter, shelfViewConfig);

        mStoreFeed.setItemClickListener(new DkShelfView.OnItemClickListener() {
            @Override
            public void onItemClick(DkShelfView shelfView, int viewId, int position) {
                System.out.println("~~~~~");
            }

            @Override
            public void onItemClick(DkShelfView shelfView, int position) {
                System.out.println("~~~~~");
            }
        });

        mStoreFeed.setItemLongPressListener(new DkShelfView.OnItemLongPressListener() {
            @Override
            public void onItemLongPress(DkShelfView shelfView, int position) {
                System.out.println("~~~~~");
            }
        });

        mStoreFeed.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });


        // 获取数据
        ShelfViewModel model = new ShelfViewModel(new DemoShelfFetcher());
        LiveData<PagedList<DkShelfBaseItem>> listLiveData = model.getBookItems();
        listLiveData.observe(this, new Observer<PagedList<DkShelfBaseItem>>() {
            @Override
            public void onChanged(PagedList<DkShelfBaseItem> dkShelfBaseItems) {
                mAdapter.submitList(dkShelfBaseItems);
            }
        });
    }

    @OnClick(R.id.title_template)
    public void setOnClick() {
        DkShelfViewConfig shelfViewConfig;
        if(mStoreFeed.getLayoutType() == ShelfLayoutType.LIST) {
            shelfViewConfig = new DkShelfViewConfig.Builder().pageSize(5).cacheSize(5).column(3).build();
        } else {
            shelfViewConfig = new DkShelfViewConfig.Builder().pageSize(5).cacheSize(5).build();
        }
        mStoreFeed.setAdapter(mAdapter, shelfViewConfig);
    }
}
