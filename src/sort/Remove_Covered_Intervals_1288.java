package sort;

import java.util.Arrays;

class Remove_Covered_Intervals_1288 {
    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            int result = 0;

            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

            int left = -1, right = -1;

            for (int[] interval : intervals) {
                if (interval[0] > left && interval[1] > right) {
                    left = interval[0];
                    result++;
                }
                right = Math.max(right, interval[1]);
            }

            return result;
        }
    }
}