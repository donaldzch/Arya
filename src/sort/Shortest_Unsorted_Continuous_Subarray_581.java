package sort;

import java.util.Arrays;

class Shortest_Unsorted_Continuous_Subarray_581 {
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int start = 0, end = -1;

            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

            for (int l = 0, r = nums.length - 1; l < nums.length && r >= 0; l++, r--) {
                max = Math.max(max, nums[l]);

                if (nums[l] != max) {
                    end = l;
                }

                min = Math.min(min, nums[r]);

                if (nums[r] != min) {
                    start = r;
                }
            }

            return end - start + 1;
        }
    }

    class Solution1 {
        public int findUnsortedSubarray(int[] nums) {
            int[] sorted = nums.clone();
            Arrays.sort(sorted);

            int start = nums.length, end = 0;

            for (int i = 0; i < nums.length; i++) {
                if (sorted[i] != nums[i]) {
                    start = Math.min(start, i);
                    end = Math.max(end, i);
                }
            }
            return end - start >= 0 ? end - start + 1 : 0;
        }
    }
}