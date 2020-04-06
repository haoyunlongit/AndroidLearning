package com.example.contentproviderclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.net.URI;
import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ContentResolver resolver = getContentResolver();
        final Uri uri = Uri.parse("content://con.hoy.contentProvider/User");
        final ContentValues values = new ContentValues();
        values.put("haha", "ffff");
        //增加
        findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        resolver.insert(uri, values);
                    }
                }).start();
            }
        });

        //删除
        findViewById(R.id.textView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resolver.delete(uri, "hah", null);
            }
        });

        //改
        findViewById(R.id.textView3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resolver.update(uri, values, "11" , null);
            }
        });

        //查找
        findViewById(R.id.textView4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resolver.query(uri, null,null,null);
            }
        });

    }
}
