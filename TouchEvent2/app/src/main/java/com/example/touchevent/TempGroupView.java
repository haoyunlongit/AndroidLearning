package com.example.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TempGroupView extends FrameLayout {
    public TempGroupView(@NonNull Context context) {
        super(context);
    }

    public TempGroupView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TempGroupView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TempGroupView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    static int i = 0;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (i > 8) {
            System.out.println("TempGroupView~~~~~onTouchEvent~~~" + false);
            return false;
        }
        boolean result = super.onTouchEvent(event);
        System.out.println("TempGroupView~~~~~onTouchEvent~~~" + result);
        return result;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        i = i + 1;
        if (i > 9) {
            if (i > 18) {
                System.out.println("TempGroupView~~~~~onInterceptTouchEvent~~~" + false + "##" + i);
                return false;
            }
            System.out.println("TempGroupView~~~~~onInterceptTouchEvent~~~" + true + "##" + i);
            return true;
        }
        boolean result = super.onInterceptTouchEvent(ev);
        System.out.println("TempGroupView~~~~~onInterceptTouchEvent~~~" + result + "##" + i);
        return result;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean result = super.dispatchTouchEvent(ev);
        System.out.println("TempGroupView~~~~~dispatchTouchEvent~~~" + result);
        return result;
    }
}
