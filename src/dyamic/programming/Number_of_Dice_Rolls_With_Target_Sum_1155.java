package dyamic.programming;


class Number_of_Dice_Rolls_With_Target_Sum_1155 {
    class Solution {
        public int numRollsToTarget(int d, int f, int target) {
            int MOD = (int)Math.pow(10, 9) + 7;
            int[][] dp = new int[d + 1][target + 1];

            dp[0][0] = 1;

            for (int i = 1; i <= d; i++) {
                for (int j = 1; j <= i * f && j <= target; j++) {
                    for (int k = 1; k <= f; k++) {
                        if (j - k >= 0) {
                            dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
                        } else {
                            continue;
                        }
                    }
                }
            }
            return dp[d][target];
        }
    }

    class Solution1 {
        public int numRollsToTarget(int d, int f, int target) {
            int MOD = (int)Math.pow(10, 9) + 7;
            int[] dp = new int[target + 1];
            dp[0] = 1;

            for (int i = 1; i <= d; i++) {
                for (int j = Math.min(i * f, target); j >= 0; j--) {
                    dp[j] = 0;
                    for (int k = j - 1; k >= Math.max(0, j - f); k--) {
                        dp[j] = (dp[j] + dp[k]) % MOD;
                    }
                }
            }
            return dp[target];
        }
    }
}