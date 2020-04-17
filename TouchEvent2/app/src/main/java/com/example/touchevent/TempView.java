package com.example.touchevent;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

@SuppressLint("AppCompatCustomView")
public class TempView extends TextView {


    public TempView(Context context) {
        super(context);
    }

    public TempView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TempView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TempView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("~~~~~onTouchEvent~~~" + true + "~~" + event.getAction());
        return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean result = super.dispatchTouchEvent(ev);
        System.out.println("TempView~~~~~dispatchTouchEvent~~~" + result);
        return result;
    }
}
