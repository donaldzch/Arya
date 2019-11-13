package array.operation;

public class Sort_Array_By_Parity_II_922 {
    class Solution {
        public int[] sortArrayByParityII(int[] A) {

            int j = 1;

            for (int i = 0; i < A.length; i += 2) {
                if (A[i] % 2 == 1) {
                    while (A[j] % 2 == 1)
                        j += 2;

                    int temp = A[j];
                    A[j] = A[i];
                    A[i] = temp;
                }
            }

            return A;
        }
    }
}
