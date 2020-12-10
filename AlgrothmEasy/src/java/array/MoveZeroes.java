package java.array;

public class MoveZeroes {
    static public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left ++;
            }
            right++;
        }

    }

    public static void main(String[] args) {

    }
}
