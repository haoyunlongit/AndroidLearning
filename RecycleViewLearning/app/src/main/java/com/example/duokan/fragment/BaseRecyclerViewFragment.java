package com.example.duokan.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shelf.R;

public class BaseRecyclerViewFragment extends Fragment {
    RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View tempView = inflater.inflate(R.layout.base_fragment, container);
        mRecyclerView = tempView.findViewById(R.id.recyclerView);
        mRecyclerView.setAdapter(new MyRecyclerViewAdapter());
        return tempView;
    }


}
