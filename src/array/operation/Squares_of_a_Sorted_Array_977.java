package array.operation;

class Squares_of_a_Sorted_Array_977 {
    class Solution {
        public int[] sortedSquares(int[] A) {
            int[] result = new int[A.length];

            int i = 0;

            while (i < A.length) {
                if (A[i] > 0) {
                    break;
                }
                i++;
            }
            int j = i;
            i--;

            int k = 0;
            while (i >= 0 && j < A.length) {
                if (A[i] * A[i] < A[j] * A[j]) {
                    result[k] = A[i] * A[i];
                    i--;
                } else {
                    result[k] = A[j] * A[j];
                    j++;
                }
                k++;
            }

            while (i >= 0) {
                result[k] = A[i] * A[i];
                i--;
                k++;
            }

            while (j < A.length) {
                result[k] = A[j] * A[j];
                j++;
                k++;
            }
            return result;
        }
    }
}