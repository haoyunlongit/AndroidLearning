package sort;

import sort.base.BaseSort;

public class ShellSort extends BaseSort {
    /**
     * 1: 注意循环的细节
     * 「 1：初始值，2：循环进行条件，3：循环结束条件 」
     * @param nums
     * @return
     */
    @Override
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int step = nums.length / 2;
        while (step > 0) {
            for (int i = step; i < nums.length; i ++) {
                for (int j = i; j - step >= 0; j -= step) {
                    if (nums[j] < nums[j - step]) {
                        int temp = nums[j - step];
                        nums[j - step] = nums[j];
                        nums[j] = temp;
                    } else {
                        break;
                    }
                }
            }
            step = step / 2;
        }
        return nums;
    }

    @Override
    public String name() {
        return "ShellSort";
    }
}
