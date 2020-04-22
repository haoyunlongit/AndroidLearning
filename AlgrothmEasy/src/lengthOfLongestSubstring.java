import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class lengthOfLongestSubstring extends AlgorithmBase {
    @Override
    void doExecute() {

    }

    /**
     * 定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * @param s
     * @return
     */

    //笔记

    /**
     *执行用时 :170 ms 在所有 Java 提交中击败了 9.43%的用户
     * 内存消耗 :40.3 MB, 在所有 Java 提交中击败了 5.20% 的用户
     * @param s
     * @return
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
}
