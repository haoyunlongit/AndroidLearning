package com.example.proxy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.lang.reflect.Proxy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.title_template).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               MyInterface temp = new MyImpClass();
               ClassHandler handler = new ClassHandler(temp);

               MyInterface proxy = (MyInterface) Proxy.newProxyInstance(temp.getClass().getClassLoader(), temp.getClass().getInterfaces(), handler);

               proxy.myMethord();

            }
        });
    }
}
