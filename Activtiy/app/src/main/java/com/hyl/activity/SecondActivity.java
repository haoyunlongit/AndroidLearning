package com.hyl.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.hyl.activity.view.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends Activity implements ViewPager.OnPageChangeListener {
    ViewPager tempPager;
    List<View> pageList = new ArrayList<View>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_main);
        tempPager = findViewById(R.id.view_pager);
        List<String> titleList = new ArrayList<String>();
        LayoutInflater li = getLayoutInflater();
        pageList.add(li.inflate(R.layout.view_one,tempPager,false));
        pageList.add(li.inflate(R.layout.view_two,tempPager,false));
        pageList.add(li.inflate(R.layout.view_three, tempPager, false));
        titleList.add("橘黄");
        titleList.add("淡黄");
        titleList.add("浅棕");
        MyPagerAdapter adapter = new MyPagerAdapter(pageList, titleList);
        tempPager.setAdapter(adapter);

        tempPager.addOnPageChangeListener(this);
        findViewById(R.id.title_template).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent tempIntent = getIntent();
        String result = tempIntent.getStringExtra("123");

        Log.i("hyllog", "SecondActivity onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("hyllog", "SecondActivity onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("hyllog", "SecondActivity onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("hyllog", "SecondActivity onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("hyllog", "SecondActivity onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("hyllog", "SecondActivity onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("hyllog", "SecondActivity onDestroy");
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
           View view = pageList.get(position);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent tempIntent = new Intent();
                    tempIntent.putExtra("time", System.currentTimeMillis());
                    setResult(444, tempIntent);
                    finish();
                }
            });
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
