package sliding.window;

class Max_Consecutive_Ones_III_1004 {
    class Solution {
        public int longestOnes(int[] A, int K) {
            int result = 0;

            int zeroCount = 0;

            int i = 0;

            for (int j = 0; j < A.length; j++) {
                if (A[j] == 0) {
                    zeroCount++;
                }

                while (zeroCount > K) {
                    if (A[i] == 0) {
                        zeroCount--;
                    }
                    i++;
                }

                result = Math.max(result, j - i + 1);
            }

            return result;
        }
    }
}