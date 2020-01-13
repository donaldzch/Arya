package dyamic.programming;

class Palindromic_Substrings_647 {
    class Solution {
        public int countSubstrings(String s) {
            int n = s.length();
            boolean[][] dp = new boolean[n][n];

            int result = 0;

            for (int i = n - 1; i >= 0; i--) {
                for (int j = i; j < n; j++) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                    if (dp[i][j]) {
                        result++;
                    }
                }
            }
            return result;
        }
    }

    class Solution1 {
        public int countSubstrings(String s) {
            int result = 0;

            for (int i = 0; i < s.length(); i++) {
                result += dfs(s, i, i);
                result += dfs(s, i, i + 1);
            }
            return result;
        }

        private int dfs(String s, int i, int j) {
            int count = 0;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                count++;
                i--;
                j++;
            }
            return count;
        }
    }
}