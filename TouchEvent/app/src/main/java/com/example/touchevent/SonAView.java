package com.example.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class SonAView extends View {
    public SonAView(Context context) {
        super(context);
    }

    public SonAView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        this.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println("#########");
//            }
//        });
    }

    public SonAView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SonAView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("onTouchEvent@@@@Begin");
        boolean result = super.onTouchEvent(event);
        System.out.println("onTouchEvent@@@@End");
        return result;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        System.out.println("dispatchTouchEvent@@@@Begin");
        boolean result = super.dispatchTouchEvent(event);
        System.out.println("dispatchTouchEvent@@@@End");
        return result;
    }
}
