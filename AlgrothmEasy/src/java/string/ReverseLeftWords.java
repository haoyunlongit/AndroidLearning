package java.string;

import java.base.AlgorithmBase;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class ReverseLeftWords extends AlgorithmBase {
    @Override
    protected void doExecute() {

    }

    public static void main(String[] args) {
        String tempStr = reverseLeftWords("2ffffssd", 2);
        System.out.println("~~~" + tempStr);
    }

    public static String reverseLeftWords(String s, int n) {
        if (s == null) {
            return null;
        }

        if (s.length() == 0) {
            return s;
        }

        n = n % s.length();
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
