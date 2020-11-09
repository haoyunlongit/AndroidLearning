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

        int temp = nums[l];
        int left = l;
        int right = r;
        while (left < right) {
            while (left < right) {
                if (nums[right] > temp) {
                    right--;
                } else {
                    nums[left] = nums[right];
                    break;
                }
            }

            while (left < right) {
                if (nums[left] <= temp) {
                    left++;
                } else {
                    nums[right] = nums[left];
                    break;
                }
            }
         }
         nums[left] = temp;
         doSort(l, left - 1,nums);
         doSort(left + 1, r, nums);
    }

    @Override
    public String name() {
        return "QuickSort";
    }
}
