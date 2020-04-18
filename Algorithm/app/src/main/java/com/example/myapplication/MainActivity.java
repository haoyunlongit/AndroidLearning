package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.title_template).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isValid(")}{({))[{{[}");
            }
        });
    }

    // 回文数
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int tempX = x;
        int tempY = 0;
        while (tempX > 0) {
            tempY = tempX % 10 + tempY * 10;
            tempX = tempX / 10;
        }
        return (tempY == x);
    }

    // 括号配对

    // 思路1 ：堆栈
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }

        if (s.length() == 0 ) {
            return true;
        }

        boolean result = false;
        Map<String, String> map = new HashMap<String, String>();
        map.put("[", "]");
        map.put("{", "}");
        map.put("(", ")");
        Stack<String> stack = new Stack<String>();
        int index = 0;
        String currentStr;
        while (index < s.length()) {
            currentStr = s.substring(index, index + 1);
            if (map.keySet().contains(currentStr)) {
                stack.add(currentStr);
            } else {
                if (stack.isEmpty() || !(map.get(stack.pop()).equals(currentStr))) {
                    result = false;
                    break;
                }
            }
            index ++;
        }

        if ((index == s.length()) && stack.isEmpty()) {
            result = true;
        }

        return result;
    }

    //将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

    /*
     * 1 :如果不是z 而是 标准矩阵
     */
    public String convert(String s, int numRows) {

        if (s == null || s.length() == 0) {
            return "";
        }

        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i ++) {
            builders[i] = new StringBuilder();
        }

        int dir = 1;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            builders[index].append(s.charAt(i));
            index = index + dir;
            if (index == 0 || index == numRows - 1) {
                dir = dir * -1;
            }
        }

        StringBuilder tempBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i ++) {
            StringBuilder builder = builders[i];
            tempBuilder.append(builder.toString());
        }
        return tempBuilder.toString();
    }


}
