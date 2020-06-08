package com.example.duokan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duokan.View.DkShelfViewAdapter;
import com.example.duokan.View.ShelfLayoutType;
import com.example.duokan.base.DkShelfViewConfig;
import com.example.shelf.R;
import com.example.duokan.View.DkShelfView;
import com.example.duokan.base.DkShelfBaseItem;
import com.example.duokan.model.ShelfViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hugo.weaving.DebugLog;

public class MainActivity extends AppCompatActivity {
    protected DkShelfView mStoreFeed;
    private DkShelfViewAdapter mAdapter;
    private ShelfViewModel mModel;
    private boolean mSelected = false;

    @BindView(R.id.change_selected)
    protected TextView mSelectedView;

    @DebugLog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mStoreFeed = (DkShelfView) findViewById(R.id.store_feed);
        mAdapter = new DkShelfViewAdapter(new DemoAdapterDelegateFactory());
        DkShelfViewConfig shelfViewConfig = new DkShelfViewConfig.Builder().pageSize(5).cacheSize(5).build();
        mStoreFeed.setAdapter(mAdapter, shelfViewConfig);

        mStoreFeed.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 0;
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
        mModel = new ShelfViewModel(new DemoShelfFetcher());
        LiveData<PagedList<DkShelfBaseItem>> listLiveData = mModel.getBookItems();
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

    @OnClick(R.id.change_selected)
    public void changeClick(TextView v) {
        mSelected = !mSelected;
        if (mSelected) {
            v.setText("选中状态");
        } else {
            v.setText("非选中状态");
            mModel.resetItemsSelectState();
        }
        mAdapter.notifyDataSetChanged();
    }
}
