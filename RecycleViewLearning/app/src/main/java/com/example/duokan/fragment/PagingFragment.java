package com.example.duokan.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duokan.DemoAdapterDelegateFactory;
import com.example.duokan.DemoShelfFetcher;
import com.example.duokan.View.DkShelfView;
import com.example.duokan.View.DkShelfViewAdapter;
import com.example.duokan.View.ShelfLayoutType;
import com.example.duokan.base.DkShelfBaseItem;
import com.example.duokan.base.DkShelfViewConfig;
import com.example.duokan.model.ShelfViewModel;
import com.example.shelf.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class PagingFragment extends Fragment {
    private Unbinder unbinder;

    protected DkShelfView mStoreFeed;
    private DkShelfViewAdapter mAdapter;
    private ShelfViewModel mModel;
    private boolean mSelected = false;

    @BindView(R.id.change_selected)
    protected TextView mSelectedView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1, container, false);
        //返回一个Unbinder值（进行解绑），注意这里的this不能使用getActivity()
        unbinder = ButterKnife.bind(this, view);
        mStoreFeed = (DkShelfView) view.findViewById(R.id.store_feed);
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
        return view;
    }

    @Override
    public void onDestroyView() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroyView();
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
