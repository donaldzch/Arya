package dyamic.programming;

class Count_Square_Submatrices_with_All_Ones_1277 {
    class Solution {
        public int countSquares(int[][] matrix) {
            int result = 0;

            int row = matrix.length;
            int col = matrix[0].length;

            int[][] dp = new int[row][col];

            for (int i = 0; i < row; i++) {
                if (matrix[i][0] == 1) {
                    dp[i][0] = 1;
                }
            }
            for (int j = 0; j < col; j++) {
                if (matrix[0][j] == 1) {
                    dp[0][j] = 1;
                }
            }

            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (matrix[i][j] == 1) {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    }
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    result += dp[i][j];
                }
            }

            return result;
        }
    }
}