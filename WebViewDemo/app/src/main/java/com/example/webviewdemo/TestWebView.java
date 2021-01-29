package com.example.webviewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebView;

public class TestWebView extends WebView {
    public TestWebView(Context context) {
        super(context);
    }

    public TestWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setVerticalScrollbarOverlay(true);
    }

    public TestWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setVerticalScrollbarOverlay(true);
    }

    public TestWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     *
     * @param deltaX 本次回掉改变了多少x
     * @param deltaY
     * @param scrollX 当前滚动的坐标
     * @param scrollY
     * @param scrollRangeX 页面支持的 x range
     * @param scrollRangeY
     * @param maxOverScrollX 水平方向最大滑动范围
     * @param maxOverScrollY
     * @param isTouchEvent  是否是手指触摸滑动, true为手指, false为惯性
     * @return
     */

    @Override
    public boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent){
//        Log.i("hyl", "==========================================================================================");
//        Log.i("hyl", "overScrollby deltaX = " + deltaX + " deltaY =" + deltaY + " scrollX =" + scrollX +
//                " scrollY =" + scrollY + " scrollRangeX =" + scrollRangeX + "scrollRangeY =" + scrollRangeY +
//                " maxOverScrollX =" + maxOverScrollX + " maxOverScrollY =" + maxOverScrollY + " isTouchEvent =" + isTouchEvent);
//        Log.i("hyl", "==========================================================================================");
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
    }


    /**
     *
     * @param l 最近位置 页面到顶部left
     * @param t 最近位置 页面到顶部距离
     * @param oldl
     * @param oldt 上一次回调 页面到顶部的距离
     */
    @Override
    protected void onScrollChanged(final int l, final int t, final int oldl,
                                   final int oldt) {
        Log.i("hyl", "==========================================================================================");
        Log.i("hyl", "onScrollChanged l = " + l + " t =" + t + " oldl =" + oldl + " oldt =" + oldt);
        Log.i("hyl", "==========================================================================================");
        super.onScrollChanged(l, t, oldl, oldt);
    }
}
