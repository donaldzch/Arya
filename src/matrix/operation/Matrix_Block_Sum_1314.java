package matrix.operation;

class Matrix_Block_Sum_1314 {
    class Solution {
        public int[][] matrixBlockSum(int[][] mat, int K) {
            int row = mat.length;
            int col = mat[0].length;

            int[][] rangeSum = new int[row + 1][col + 1];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    rangeSum[i + 1][j + 1] = rangeSum[i + 1][j] + rangeSum[i][j + 1] - rangeSum[i][j] + mat[i][j];
                }
            }

            int[][] result = new int[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int r1 = Math.max(0, i - K), c1 = Math.max(0, j - K), r2 = Math.min(row - 1, i + K), c2 = Math.min(col - 1, j + K);
                    r1++;
                    c1++;
                    r2++;
                    c2++;
                    result[i][j] = rangeSum[r2][c2] - rangeSum[r1 - 1][c2] - rangeSum[r2][c1 - 1] + rangeSum[r1 - 1][c1 - 1];
                }
            }

            return result;
        }
    }
}