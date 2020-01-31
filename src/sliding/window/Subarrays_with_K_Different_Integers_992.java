package sliding.window;

import java.util.*;

class Subarrays_with_K_Different_Integers_992 {
    class Solution {
        public int subarraysWithKDistinct(int[] A, int K) {
            return atMost(A, K) - atMost(A, K - 1);
        }

        private int atMost(int[] A, int K) {
            int result = 0;

            int i = 0;

            Map<Integer, Integer> count = new HashMap<>();

            for (int j = 0; j < A.length; j++) {
                if (count.getOrDefault(A[j], 0) == 0) {
                    K--;
                }
                count.put(A[j], count.getOrDefault(A[j], 0) + 1);

                while (K < 0) {
                    count.put(A[i], count.get(A[i]) - 1);
                    if (count.get(A[i]) == 0) {
                        K++;
                    }
                    i++;
                }

                result += j - i + 1;
            }

            return result;
        }
    }
}