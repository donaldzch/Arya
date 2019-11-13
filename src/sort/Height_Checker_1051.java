package sort;

public class Height_Checker_1051 {
    class Solution {
        public int heightChecker(int[] heights) {
            int[] count = new int[101];
            for (int height : heights) {
                count[height]++;
            }
            int result = 0;
            int current = 0;

            for (int i = 0; i < heights.length; i++) {
                while (count[current] == 0) {
                    current++;
                }
                if (current != heights[i]) {
                    result++;
                }
                count[current]--;
            }

            return result;
        }
    }
}
