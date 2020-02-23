package bit.operation;

class Total_Hamming_Distance_477 {
    class Solution {
        public int totalHammingDistance(int[] nums) {
            int ones = 0;
            int zeros = 0;

            int result = 0;

            for (int i = 0; i < 32; i++) {
                ones = 0;
                zeros = 0;
                for (int j = 0; j < nums.length; j++) {
                    if ((nums[j] & 1) == 1) {
                        ones++;
                    } else {
                        zeros++;
                    }
                    nums[j] >>= 1;
                }
                result += ones * zeros;
            }

            return result;
        }
    }
}