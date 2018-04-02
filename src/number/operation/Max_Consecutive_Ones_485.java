package number.operation;

public class Max_Consecutive_Ones_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                count = 0;
            else
                count++;
            if (max < count)
                max = count;
        }
        return max;
    }

    public int findMaxConsecutiveOnes1(int[] nums) {
        int max = 0, count = 0;
        for (int num : nums) {
            max = Math.max(max, count = num == 0 ? 0 : count + 1);
        }
        return max;
    }
}
