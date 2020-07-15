package com.hyl.serializablelearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.title_template).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setId(1000);
                user.setName("韩梅梅韩梅梅韩梅梅韩梅梅韩梅梅韩梅梅韩梅梅韩梅梅韩梅梅韩梅梅韩梅梅韩梅梅韩梅梅韩梅梅v");

                // 把对象序列化到文件
                ObjectOutputStream oos = null;
                try {
                    oos = new ObjectOutputStream(new FileOutputStream("/serializable/user.txt"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    oos.writeObject(user);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }



}
