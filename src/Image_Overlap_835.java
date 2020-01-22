import java.util.HashMap;
import java.util.*;

class Image_Overlap_835 {
    class Solution {
        public int largestOverlap(int[][] A, int[][] B) {
            Map<Integer, Integer> count = new HashMap<>();

            List<Integer> listA = new ArrayList<>();

            List<Integer> listB = new ArrayList<>();

            int N = A.length;

            for (int i = 0; i < N * N; i++) {
                if (A[i / N][i % N] == 1) {
                    listA.add(i / A.length * 100 + i % A.length);
                }
            }

            for (int i = 0; i < N * N; i++) {
                if (B[i / N][i % N] == 1) {
                    listB.add(i / B.length * 100 + i % B.length);
                }
            }

            for (int i : listA) {
                for (int j : listB) {
                    count.put(i - j, count.getOrDefault(i - j, 0) + 1);
                }
            }

            int result = 0;
            for (int value : count.values()) {
                result = Math.max(result, value);
            }

            return result;
        }
    }
}