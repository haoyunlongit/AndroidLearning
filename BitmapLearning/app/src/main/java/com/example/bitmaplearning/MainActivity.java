package com.example.bitmaplearning;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Picture;
import android.os.Bundle;
import android.view.ViewGroup;

import java.util.Timer;
import java.util.TimerTask;

import static android.graphics.Bitmap.*;
import static android.graphics.Bitmap.Config.ARGB_8888;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewGroup group = findViewById(R.id.content_view);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                group.invalidate();
            }
        }, 2000);

    }


}
