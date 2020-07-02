package com.hyl.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.handlerView) TextView animationView;

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
        Animation animation = new TranslateAnimation(0, 200, 0, 200);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        animationView.startAnimation(animation);
    }

    public void animation2Method(View v) {
        System.out.println("~~~~~~~~~~~~~");
    }

    public void animation3Method(View v) {
        System.out.println("~~~~~~~~~~~~~");
    }
    /**
     *===================================
     */
}
