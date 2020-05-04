package string;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubString  {

    /**
     *      利用hashmap 查找优势 n^2 时间复杂度获取最大的长度
     *      空间复杂度 n
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashSet<Character> hashSet = new HashSet<Character>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if(!hashSet.contains(s.charAt(j))) {
                    hashSet.add(s.charAt(j));
                    if (max < hashSet.size()) {
                        max = hashSet.size();
                    }
                } else {
                    hashSet.clear();
                    break;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring2("abcabcbb");
    }

    /**
     * 滑动窗口法，时间复杂度O(n)
     * @param s
     * @return
     */
    static public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int maxLength = 0;
        int start = 0;
        for (Integer end = 0; end < s.length(); end++) {
            Character character = s.charAt(end);
            if (hashMap.get(character) != null) {
                start = Math.max(start, hashMap.get(character) + 1);
            }
            hashMap.put(character, end);
            maxLength = Math.max(maxLength, end + 1 - start);
        }

        return maxLength;
    }
}
