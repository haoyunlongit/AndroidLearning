package com.hyl.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.title_template).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Log.i("hyllog", "SecondActivity onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("hyllog", "SecondActivity onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("hyllog", "SecondActivity onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("hyllog", "SecondActivity onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("hyllog", "SecondActivity onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("hyllog", "SecondActivity onPause");
    }
}
