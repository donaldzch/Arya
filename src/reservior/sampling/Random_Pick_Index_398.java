package reservior.sampling;

import java.util.*;

class Random_Pick_Index_398 {
    class Solution {

        private int[] nums;
        private Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            this.random = new Random();
        }
        
        public int pick(int target) {
            int result = -1;

            int count = 0;

            for (int i = 0; i < this.nums.length; i++) {
                if (nums[i] != target) {
                    continue;
                }
                if (random.nextInt(++count) == 0) {
                    result = i;
                }
            }
            return result;
        }
    }
}