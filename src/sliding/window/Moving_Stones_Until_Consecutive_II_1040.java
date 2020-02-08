package sliding.window;

import java.util.*;

class Moving_Stones_Until_Consecutive_II_1040 {
    class Solution {
        public int[] numMovesStonesII(int[] stones) {
            Arrays.sort(stones);
            int low = Integer.MAX_VALUE;
            int n = stones.length;

            int i = 0;
            for (int j = 0; j < n; j++) {
                while (stones[j] - stones[i] >= n) {
                    i++;
                }
                if (j - i + 1 == n - 1 && stones[j] - stones[i] == n - 2) {
                    low = Math.min(low, 2);
                } else {
                    low = Math.min(low, n - (j - i + 1));
                }
            }

            int high = Math.max(stones[n - 2] - stones[0] - n + 2, stones[n - 1] - stones[1] - n + 2);
            return new int[]{low, high};
        }
    }
}