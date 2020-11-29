package array;

public class MoveZeroes {
    static public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int left = 0, right = 0;
        while (left != nums.length - 1) {
           while (nums[right] == 0) {
               left++;
           }
           right++;
        }
    }

    static private void swift(int left, int right, int[] nums) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] number = new int[]{0,1,0,3,12};
        moveZeroes(number);
    }
}
