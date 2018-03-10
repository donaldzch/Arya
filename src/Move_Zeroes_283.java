public class Move_Zeroes_283 {
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (k < i) {
                    nums[k] = nums[i];
                    nums[i] = 0;
                }
                k++;
            }
        }
    }
}
