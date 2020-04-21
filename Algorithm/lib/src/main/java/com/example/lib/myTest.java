package com.example.lib;

public class myTest {
    public String test(String s) {
        if (s == null) {
            return "";
        }

        int[][] arr = new int[s.length()][s.length()];
        String reverse = new StringBuffer(s).reverse().toString();
        String result = "";
        int maxLength = 0;
        int chartInt = 0;
        for (int i = 0; i < s.length(); i ++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }

                    if (arr[i][j] > maxLength) {
                        int reverseIndex = s.length() - j - 1;
                        if (reverseIndex == i + 1 - maxLength) {
                            maxLength = arr[i][j];
                            chartInt = i;
                        }
                    }
                }
            }
        }
        if (maxLength > 0) {
            result = s.substring(chartInt, chartInt + maxLength);
        }
        return result;
    }

    public static void main(String args[]) {
        String tempStr = test("abaacbb");
        System.out.println("~~~" + tempStr);
    }
}
