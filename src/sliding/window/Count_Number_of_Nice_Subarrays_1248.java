package sliding.window;

class Count_Number_of_Nice_Subarrays_1248 {
    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            return atMost(nums, k) - atMost(nums, k - 1);
        }

        private int atMost(int[] nums, int k) {
            int result = 0;
            int i = 0;

            for (int j = 0; j < nums.length; j++) {
                k -= nums[j] % 2;
                while (k < 0) {
                    k += nums[i] % 2;
                    i++;
                }
                result += j - i + 1;
            }

            return result;
        }
    }
}