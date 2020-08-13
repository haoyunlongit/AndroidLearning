package com.hyl.hotfix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        findViewById(R.id.title_template).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                BugClass bugClass = new BugClass();
//                bugClass.doSome();
//            }
//        });

        LoadBugClass loadBugClass = new LoadBugClass();
        loadBugClass.getBugString();

        com.hyl.test.LoadBugClass temp = new com.hyl.test.LoadBugClass();
        temp.getClass();
    }
}