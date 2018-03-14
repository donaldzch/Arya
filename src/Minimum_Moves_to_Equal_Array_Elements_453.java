public class Minimum_Moves_to_Equal_Array_Elements_453 {

    /**
     * sum + m * (n-1) = x * n
     * x = min + m
     *
     * m = sum - min * n
     *
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int sum = 0; int min = nums[0];

        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }

        return sum - min*nums.length;
    }
}
