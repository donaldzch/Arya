package dyamic.programming;

class Maximum_Length_of_Repeated_Subarray_718 {
    class Solution {
        public int findLength(int[] A, int[] B) {
            int[][] dp = new int[A.length + 1][B.length + 1];

            int result = 0;
            for (int i = 1; i <= A.length; i++) {
                for (int j = 1; j <= B.length; j++) {
                    if (A[i - 1] == B[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        result = Math.max(result, dp[i][j]);
                    }
                }
            }
            return result;
        }
    }

    class Solution1 {
        public int findLength(int[] A, int[] B) {
            int[] dp = new int[B.length + 1];

            int result = 0;

            for (int i = 1; i <= A.length; i++) {
                for (int j = B.length; j > 0; j--) {
                    if (A[i - 1] == B[j - 1]) {
                        dp[j] = dp[j - 1] + 1;
                        result = Math.max(result, dp[j]);
                    } else {
                        dp[j] = 0;
                    }
                }
            }
            return result;
        }
    }
}