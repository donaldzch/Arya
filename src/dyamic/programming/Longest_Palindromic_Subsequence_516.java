package dyamic.programming;

class Longest_Palindromic_Subsequence_516 {
    class Solution {
        public int longestPalindromeSubseq(String s) {
            int[][] dp = new int[s.length()][s.length()];

            for (int i = s.length() - 1; i >= 0; i--) {
                dp[i][i] = 1;

                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[0][s.length() - 1];
        }
    }

    class Solution1 {
        public int longestPalindromeSubseq(String s) {
            int[] dp = new int[s.length()];

            for (int i = s.length() - 1; i >= 0; i--) {
                dp[i] = 1;
                int prev = 0;

                for (int j = i + 1; j < s.length(); j++) {
                    int temp = dp[j];
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[j] = prev + 2;
                    } else {
                        dp[j] = Math.max(dp[j], dp[j - 1]);
                    }
                    prev = temp;
                }
            }
            return dp[s.length() - 1];
        }
    }
}