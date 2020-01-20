package dyamic.programming;

class Arithmetic_Slices_413 {
    class Solution {
        public int numberOfArithmeticSlices(int[] A) {
            int[] dp = new int[A.length + 2];
            dp[0] = 0;
            dp[1] = 0;

            int sum = 0;

            for (int i = 2; i < A.length; i++) {
                if (A[i - 1] - A[i - 2] == A[i] - A[i - 1]) {
                    dp[i] = dp[i - 1] + 1;
                    sum += dp[i];
                } else {
                    dp[i] = 0;
                }
            }
            return sum;
        }
    }
}