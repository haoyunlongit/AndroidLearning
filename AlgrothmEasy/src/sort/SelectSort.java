package sort;

/**
 * 插入排序
 */
public class SelectSort extends BaseSort {
    @Override
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return nums;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                   minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
        return nums;
    }

    @Override
    public String name() {
        return "SelectSort";
    }
}
