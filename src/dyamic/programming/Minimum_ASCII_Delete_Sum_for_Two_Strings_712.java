package dyamic.programming;

class Minimum_ASCII_Delete_Sum_for_Two_Strings_712 {
    class Solution {
        public int minimumDeleteSum(String s1, String s2) {
            int row = s1.length();
            int col = s2.length();

            int[][] dp = new int[row + 1][col + 1];

            for (int i = 1; i <= row; i++) {
                dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
                for (int j = 1; j <= col; j++) {
                    dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                    }

                }
            }
            return dp[row][col];
        }
    }
}