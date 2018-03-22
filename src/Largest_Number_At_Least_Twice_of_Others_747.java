public class Largest_Number_At_Least_Twice_of_Others_747 {
    public int dominantIndex(int[] nums) {
        if (nums == null)
            return -1;
        if (nums.length == 1) {
            return -1;
        }

        int max = 0, secondMax = 0, index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max= nums[i];
                index = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }

        return max > 2 * secondMax ? index : -1;
    }
}
