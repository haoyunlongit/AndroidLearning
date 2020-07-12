package com.hyl.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.handlerView) TestTextView animationView;
    long time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    /**
     * 学习animation 相关方法
     * ===================================
     */
    public void animation1Method(View v) {
        animationView.setVisibility(View.VISIBLE);
        Animation animation = new TranslateAnimation(0, 200, 0, 200);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        animationView.startAnimation(animation);
    }

    public void animation2Method(View v) {
        animationView.setBackgroundColor(Color.BLUE);

    }

    public void animation3Method(View v) {
        System.out.println("~~~~~~~~~~~~~");
    }

    /**
     *===================================
     */


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        time = System.currentTimeMillis();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        System.out.println("~~~~~~~~~~" + (System.currentTimeMillis() - time));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
