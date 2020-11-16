package java.sort.sortMethod;

import java.sort.base.BaseSort;

/**
 * 1:用到了递归
 *   递归的3要素：
 *   a：初始条件 b：结束条件 c：中间状态
 */

public class QuickSort extends BaseSort {
    @Override
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        doSort(0, nums.length - 1, nums);
        return nums;
    }

    void doSort(int l, int r, int[] nums) {
       if (l >= r) {
           return;
       }
       int targetNum = nums[l];
       int left = l;
       int right = r;
       while (left < right) {
           while (nums[right] >= targetNum && left < right) {
               right --;
           }
           nums[left] = nums[right];
           while (nums[left] < targetNum && left < right) {
               left++;
           }
           nums[right] = nums[left];
       }

        nums[right] = targetNum;
        doSort(l, right - 1, nums);
        doSort(right + 1, r, nums);
    }

    @Override
    public String name() {
        return "QuickSort";
    }
}
