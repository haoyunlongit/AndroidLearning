package java.array;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MaxSubArray {

    /**
     * 思路：
     * 1：遍历数组
     * 2：判断之前子串和是否 >= 0
     * 3：大于零那么子串长度加一，子串和加上当前数
     * 4：小于零子串和清零，重新记录子串和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = Integer.MIN_VALUE;
        int curSub = 0;
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            if (curSub >= 0) {
                curSub = curSub + curNum;
            } else {
                curSub = curNum;
            }
            result = Math.max(result, curSub);
        }
        return result;
    }
}
