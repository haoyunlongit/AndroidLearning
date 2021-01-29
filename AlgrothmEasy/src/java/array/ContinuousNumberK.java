package java.array;

import java.util.HashMap;

/**
 * 给定一个包含 非负数 的数组和一个目标 整数 k，
 * 编写一个函数来判断该数组是否含有连续的子数组，
 * 其大小至少为 2，且总和为 k 的倍数，即总和为 n*k，
 * 其中 n 也是一个整数。
 *
 * [23,2,4,6,7], k = 6
 * 输出：True
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6。
 */
public class ContinuousNumberK {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        /**
         * 需要0值设置一个初始值
         * 否则 [0,1,0] 这个case会通不过
         */
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println("~~~~~");
    }
}
