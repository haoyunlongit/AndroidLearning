package sort;

import sort.base.BaseSort;

import java.lang.reflect.Array;
import java.util.Arrays;

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
