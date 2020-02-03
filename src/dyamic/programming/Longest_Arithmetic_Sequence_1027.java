package dyamic.programming;

import java.util.*;

class Longest_Arithmetic_Sequence_1027 {
    class Solution {
        public int longestArithSeqLength(int[] A) {
            int result = 2;

            Map<Integer, Integer>[] dp = new HashMap[A.length];

            for (int i = 0; i < A.length; i++) {
                dp[i] = new HashMap<>();
                for (int j = 0; j < i; j++) {
                    int diff = A[i] - A[j];
                    dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                    result = Math.max(result, dp[i].get(diff));
                }
            }

            return result;
        }
    }
}