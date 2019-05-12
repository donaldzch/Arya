package dyamic.programming;

import java.util.Arrays;

public class Stone_Game_877 {
    class Solution {
        public boolean stoneGame(int[] piles) {
            int n = piles.length;
            int[] dp = Arrays.copyOf(piles, n);
            for (int d = 1; d < n; d++)
                for (int i = 0; i < n - d; i++)
                    dp[i] = Math.max(piles[i] - dp[i + 1], piles[i + d] - dp[i]);
            return dp[0] > 0;
        }
    }
}
