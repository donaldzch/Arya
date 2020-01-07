package dyamic.programming;

class Partition_Array_for_Maximum_Sum_1043 {
    class Solution {
        public int maxSumAfterPartitioning(int[] A, int K) {
            int[] dp = new int[A.length];

            int result = 0;

            for (int i = 0; i < A.length; i++) {
                int localMax = 0;
                for (int k = 1; k <= K; k++) {
                    int j = i - k + 1;
                    if (j >= 0) {
                        localMax = Math.max(localMax, A[j]);
                        dp[i] = Math.max(dp[i], (i >= k ? dp[i - k] : 0) + localMax * k);
                    }
                }
            }

            return result;
        }
    }
}