package array.operation;

class N_Repeated_Element_in_Size_2N_Array_961 {
    class Solution {
        public int repeatedNTimes(int[] A) {

            int result = 0;
            for (int k = 1; k <=3; k++) {
                for (int i = 0; i < A.length - k; i++) {
                    if (A[i] == A[i + k]) {
                        result = A[i];
                        break;
                    }
                }
            }
            return result;
        }
    }
}