package array.operation;

public class Maximum_Average_Subarray_I_643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        for (int i = 0; i < k; i++)
            sum += nums[i];

        int max = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }

        return max / k;
    }
}
