package java.string;

import java.util.HashMap;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 */

/**
 * case：
 * "java.tree" -> "eetr"
 * "abaccadeeefaafcc" -> "aaaaacccceeeffbd"
 */

/**
 * 思路：
 * 1：统计频率
 * 2：按照出现的频率拼接字符
 */

public class FrequencySort {
    public String frequencySort(String s) {
        if (s == null) {
            return null;
        }

        if (s.length() == 0) {
            return s;
        }

        HashMap<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if(frequencyMap.get(character) == null) {
                frequencyMap.put(character, 1);
            } else {
                Integer count = frequencyMap.get(character);
                frequencyMap.put(character, count + 1);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!frequencyMap.isEmpty()) {
            int max = 0;
            Character targetKey = null;
            for (Character key : frequencyMap.keySet()) {
                Integer count = frequencyMap.get(key);
                if (count > max) {
                    max  = count;
                    targetKey = key;
                }
            }

            if (targetKey != null) {
                frequencyMap.remove(targetKey);
                for (int i = 0; i < max; i++) {
                    builder.append(targetKey);
                }
            }
        }
        return builder.toString();
    }
}
