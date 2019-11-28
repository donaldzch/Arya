package number.operation;

import java.util.ArrayList;

class Add_to_Array_Form_of_Integer_989 {
    class Solution {
        public List<Integer> addToArrayForm(int[] A, int K) {
            List<Integer> result = new ArrayList<>();
            for (int i = A.length - 1; i >=0; i--) {
                result.add(0, (A[i] + K) % 10);
                K = (A[i] + K) / 10;
            }

            while (K > 0) {
                result.add(0, K % 10);
                K /= 10;
            }

            return result;
        }
    }
}