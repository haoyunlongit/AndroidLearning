package com.example.broadercastreceiverclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.title_template).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       Intent intent = new Intent("com.hoy.broadercasetReceiver");
//                ComponentName componentName = new ComponentName(getPackageName(), MainActivity.this.getClass().getName());
//                intent.setComponent(componentName);
                       intent.setPackage(getPackageName());
                       sendBroadcast(intent,"com.hoy.broadercastReceiver");
                   }
               }).start();
            }
        });
    }
}
