package com.example.touchevent;


import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class SonBView extends View {
    String TAG = "touch~~";
    public SonBView(Context context) {
        super(context);
    }

    public SonBView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SonBView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SonBView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = super.onTouchEvent(event);
        Log.i(TAG, "onTouchEvent~~~~~SonBView" + event.getAction() + "result = " + result);
        return result;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean result = super.dispatchTouchEvent(event);
        Log.i(TAG, "dispatchTouchEvent~~~~~SonBView" + event.getAction() + "result = " + result);
        return result;
    }
}
