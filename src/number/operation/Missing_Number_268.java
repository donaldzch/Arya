package number.operation;

public class Missing_Number_268 {
    public int missingNumber(int[] nums) {
        int result = nums.length;

        for (int i = 0; i < nums.length; i++) {
            result ^= i;
            result ^= nums[i];
        }

        return result;
    }

    public int missingNumber1(int[] nums) {
        int result = nums.length;

        for (int i = 0; i < nums.length; i++) {
            result += i;
            result -= nums[i];
        }
        return result;
    }
}
