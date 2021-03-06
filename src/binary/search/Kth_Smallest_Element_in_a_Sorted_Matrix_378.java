package binary.search;

class Kth_Smallest_Element_in_a_Sorted_Matrix_378 {
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int low = matrix[0][0], high = matrix[matrix.length - 1][matrix.length - 1];

            while (low < high) {
                int mid = low + (high - low) / 2;
                int count = 0;
                for (int i = 0; i < matrix.length; i++) {
                    int j = matrix.length - 1;
                    while (j >= 0 && matrix[i][j] > mid) {
                        j--;
                    }
                    count += (j + 1);
                }
                if (count < k) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }
}