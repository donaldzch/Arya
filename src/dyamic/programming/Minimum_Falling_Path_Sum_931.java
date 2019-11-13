package dyamic.programming;

public class Minimum_Falling_Path_Sum_931 {
    class Solution {
        public int minFallingPathSum(int[][] A) {
            int row = A.length;
            int col = A[0].length;
            int[][] dp = new int[row][col];

            for (int j = 0; j < col; j++) {
                dp[0][j] = A[0][j];
            }

            for (int i = 1; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int min = dp[i - 1][j];
                    if (j > 0) {
                        min = Math.min(min, dp[i - 1][j - 1]);
                    }
                    if (j < col - 1) {
                        min = Math.min(min, dp[i - 1][j + 1]);
                    }
                    dp[i][j] = A[i][j] + min;
                }
            }

            int result = Integer.MAX_VALUE;
            for (int j = 0; j < col; j++) {
                result = Math.min(result, dp[row - 1][j]);
            }

            return result;
        }
    }
}
