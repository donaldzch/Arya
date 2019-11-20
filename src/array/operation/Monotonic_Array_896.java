package array.operation;

class Monotonic_Array_896 {
    class Solution {
        public boolean isMonotonic(int[] A) {
            boolean increase = true, decrease = true;

            for (int i = 0; i < A.length - 1; i++) {
                increase &= A[i] <= A[i+1];
                decrease &= A[i] >= A[i+1];
            }

            return increase || decrease;
        }
    }
}