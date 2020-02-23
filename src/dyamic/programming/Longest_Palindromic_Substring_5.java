package dyamic.programming;

class Longest_Palindromic_Substring_5 {
    class Solution {
        public String longestPalindrome(String s) {
            boolean[][] dp =  new boolean[s.length()][s.length()];
            int maxLength = 0;
            int start = 0;

            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }
                    if (dp[i][j] && j - i + 1 >= maxLength) {
                        start = i;
                        maxLength = j - i + 1;
                    }
                }
            }
            return s.substring(start, start + maxLength);
        }
    }

    class Solution1 {
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 1) return "";
            int start = 0;
            int end = 0;

            for (int i = 0; i < s.length(); i++) {
                int len1 = expand(s, i, i);
                int len2 = expand(s, i, i + 1);
                int maxLength = Math.max(len1, len2);

                if (maxLength > end - start) {
                    start = i - (maxLength - 1) / 2;
                    end = i + maxLength / 2;
                }
            }

            return s.substring(start, end + 1);
        }

        private int expand(String s, int left, int right) {
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return right - left - 1;
        }
    }
}