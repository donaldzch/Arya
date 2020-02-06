import java.util.*;

class Four_Sum_II_454 {
    class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            int result = 0;

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B.length; j++) {
                     map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
                }
            }

            for (int i = 0; i < C.length; i++) {
                for (int j = 0; j < D.length; j++) {
                    result += map.getOrDefault(-1 * (C[i] + D[j]), 0);
                }
            }

            return result;
        }
    }
}