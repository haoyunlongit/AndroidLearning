package sort;

import sort.base.BaseSort;

/**
 * 从头开始插入 保证插入的元素 顺序相同
 */
public class InsertSort extends BaseSort {
    @Override
    public int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j - 1 >= 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                } else {
                    break;
                }
            }
        }
        return nums;
    }

    @Override
    public String name() {
        return "InsertSort";
    }
}
