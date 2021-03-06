package dyamic.programming;

class Uncrossed_Lines_1035 {
    class Solution {
        public int maxUncrossedLines(int[] A, int[] B) {
            int m = A.length;
            int n = B.length;

            int[][] dp = new int[m + 1][n + 1];

            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (A[i - 1] == B[j - 1]) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            return dp[m][n];
        }
    }
}