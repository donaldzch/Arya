package array.operation;

public class Find_Pivot_Index_724 {
    public int pivotIndex(int[] nums) {
        int sum = 0;

        for (int num : nums)
            sum += num;
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] - leftSum == leftSum)
                return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
