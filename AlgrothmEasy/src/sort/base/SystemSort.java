package sort.base;

import java.util.Arrays;

public class SystemSort extends BaseSort {
    @Override
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    @Override
    public String name() {
        return "SystemSort";
    }
}
