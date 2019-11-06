package array.operation;

public class Sort_Array_By_Parity_905 {
    class Solution {
        public int[] sortArrayByParity(int[] A) {
            int i = 0;

            while (i < A.length && A[i] % 2 == 0) {
                i++;
            }

            for (int j = i + 1; j < A.length; j++) {
                if (A[j] % 2 == 0) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                    i++;
                }
            }
            return A;
        }
    }
}
