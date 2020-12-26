package com.example.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class SonAView extends ViewGroup {
    String TAG = "touch~~";

    public SonAView(Context context) {
        super(context);
    }

    public SonAView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("touch", "~~~#########");
            }
        });
    }

    public SonAView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SonAView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "~~~SonA onTouchEvent@@@@Begin");
        boolean result = super.onTouchEvent(event);
        Log.i(TAG, "~~~SonA onTouchEvent@@@@End");
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i(TAG, "~~~SonA onInterceptTouchEvent@@@@End");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i(TAG, "~~~SonA dispatchTouchEvent@@@@Begin");
        boolean result = super.dispatchTouchEvent(event);
        Log.i(TAG, "~~~SonA dispatchTouchEvent@@@@End");
        return result;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
