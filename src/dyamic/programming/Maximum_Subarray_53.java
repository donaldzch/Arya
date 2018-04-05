package dyamic.programming;

public class Maximum_Subarray_53 {
    public int maxSubArray(int[] nums) {
        int maxEndingHere = nums[0], maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
