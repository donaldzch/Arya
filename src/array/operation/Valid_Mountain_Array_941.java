package array.operation;

class Valid_Mountain_Array_941 {
    class Solution {
        public boolean validMountainArray(int[] A) {
            int i = 0, j = A.length - 1;
            while (i < A.length - 1) {
                if (A[i] < A[i+1]) {
                    i++;
                } else {
                    break;
                }
            }

            while (j > 0) {
                if (A[j] < A[j - 1]){
                    j--;
                } else {
                    break;
                }
            }
            return i > 0 && i == j && j < A.length - 1;
        }
    }
}