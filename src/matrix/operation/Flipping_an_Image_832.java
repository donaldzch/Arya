package matrix.operation;

public class Flipping_an_Image_832 {
    class Solution {
        public int[][] flipAndInvertImage(int[][] A) {
            int row = A.length;
            int col = A[0].length;

            int[][] result = new int[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < (col + 1) / 2; j++) {
                    if (A[i][j] == A[i][col - j - 1]) {
                        result[i][j] = A[i][j] ^ 1;
                        result[i][col - 1 - j] = A[i][col - 1 - j] ^ 1;
                    } else {
                        result[i][j] = A[i][j];
                        result[i][col - 1 - j] = A[i][col - 1 - j];
                    }
                }
            }

            return result;
        }
    }
}
