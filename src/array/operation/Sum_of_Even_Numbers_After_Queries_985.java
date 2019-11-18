package array.operation;

import java.util.HashSet;
import java.util.Set;

class Sum_of_Even_Numbers_After_Queries_985 {
    class Solution {
        public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
            int sum = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i] % 2 == 0) {
                    sum += A[i];
                }
            }

            int[] result = new int[queries.length];

            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                int oldValue = A[query[1]];
                int newValue = oldValue + query[0]; 

                if (oldValue % 2 == 0) {
                    sum -= oldValue;
                }
                if (newValue % 2 == 0) {
                    sum += newValue;
                }
                A[query[1]] = newValue;
                result[i] = sum;
            }

            return result;
        }
    }
}