package com.example.longestpalindrome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.temp_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                longestPalindrome("bb");
            }
        });
    }

    /*
    1: 字符串长度 1  也是回纹！
    2： 注意在同一个字符串内相反的两个子串 "aacdefcaa"
    3: 字符串 通过下标志 获得子字符串  substring(int beginIndex, int endIndex) endIndex + 1
     */

    public String longestPalindrome(String s) {
        if (s == null) {
            return "";
        }

        if (s.length() == 1) {
            return s;
        }

        int[][] arr = new int[s.length()][s.length()];
        int max = -1;
        int index = 0;
        // j 代表子串长度
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i < s.length() - j; i++) {
                if (s.charAt(i) == s.charAt(i + j)) {
                    if (j == 0 || (j == 1)) {
                        arr[i][j] = 1;
                        if (max < j) {
                            index = i;
                            max = j;
                        }
                    } else if (arr[i + 1][j - 2] > 0) {
                        arr[i][j] = 1;
                        if (max < j) {
                            index = i;
                            max = j;
                        }
                    }
                }
            }
        }
        return s.substring(index, index + max + 1);
    }


    /*
    定位有多少个回文

    输入: "aaa"
    输出: 6
    说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subStr = s.substring(i, j + 1);
                String revertStr = new StringBuffer(subStr).reverse().toString();
                if (subStr.equals(revertStr)) {
                    result ++;
                }
            }
        }
        return result;
    }

//    boolean isTargetStr(String s) {
//        if (s.length() == 1) {
//            return true;
//        }
//
//        boolean result = true;
//        for (int i = 0; i < s.length() >> 1; i++) {
//             if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
//                 result = false;
//                 break;
//             }
//        }
//        return result;
//    }

}
