package com.hyl.animation;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class TestTextView extends androidx.appcompat.widget.AppCompatTextView {
    public TestTextView(Context context) {
        super(context);
    }

    public TestTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

//    @Override
//    protected void onAttachedToWindow() {
//        super.onAttachedToWindow();
//        System.out.println("view on visible");
//
//    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        System.out.println("view on visible");
    }

    public void invalidate() {
        super.invalidate();
        System.out.println("~~~~~~~~");
    }
}
