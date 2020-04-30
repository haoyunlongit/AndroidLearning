package string;

import base.AlgorithmBase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.Vector;

/**
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：
 * 每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，
 * 在子字符串中都恰好出现了偶数次。
 *
 * 输入：s = "eleetminicoworoep"
 * 输出：13
 * 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
 *
 * 输入：s = "leetcodeisgreat"
 * 输出：5
 * 解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
 */
public class FindTheLongestSubstring extends AlgorithmBase {
    HashMap<String, Integer> map = new HashMap<>();

    @Override
    protected void doExecute() {

    }

    public static void main(String[] args) {
       int temp = findTheLongestSubstring("gdderrttyc");
       System.out.println("~~" + temp);
    }

    public static int findTheLongestSubstring(String s) {
        int n = s.length(), res = 0;
        int[] dp = new int[32];
        int cur = 0;
        Arrays.fill(dp, n);
        dp[0] = -1;
        for(int i = 0 ; i < n ; i++){
            int id = getIndex(s.charAt(i));
            if(id >= 0) {
                cur ^= (1 << id);
            }
            dp[cur] = Math.min(dp[cur], i);
            res = Math.max(res, i - dp[cur]);
            if (res == 6) {
                System.out.println("~~~~~~~~~~~");
            }
        }
        return res;
    }

    private static int getIndex(char c){
        if(c == 'a'){
            return 0;
        } else if(c == 'e'){
            return 1;
        } else if(c == 'i'){
            return 2;
        } else if(c == 'o'){
            return 3;
        } else if(c == 'u'){
            return 4;
        } else {
            return -1;
        }
    }
}
