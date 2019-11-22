package array.operation;

import java.util.Comparator;

class Maximize_Sum_Of_Array_After_K_Negations_1005 {
    class Solution {
        public int largestSumAfterKNegations(int[] A, int K) {
            int result = 0;

            Arrays.sort(A);

            int i = 0;
            for (i = 0; i < A.length; i++) {
                if (K == 0) {
                    break;
                }
                if (A[i] < 0) {
                    result -= A[i];
                    A[i] = -A[i];
                    K--;
                } else {
                    break;
                }
            }
            K = K % 2;

            if (K == 1) {
                if (A[i] != 0) {
                    if (i > 0) {
                        if (A[i - 1] < A[i]) {
                            result -= 2 * A[i - 1];
                        } else {
                            result -= A[i];
                            i++;
                        }
                    } else {
                        result -= A[i];
                        i++;
                    }
                }                
            }

            for (int j = i; j < A.length; j++) {
                result += A[j];
            }

            return result;
        }
    }
}