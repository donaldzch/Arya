package bit.operation;

import java.util.Arrays;

class Flip_Colummns_For_Maximum_Number_of_Equal_Rows_1072 {
    class Solution {
        public int maxEqualRowsAfterFlips(int[][] matrix) {
            int result = 0;
            int row = matrix.length;
            int col = matrix[0].length;

            int[] flip = new int[col];
            for (int i = 0; i < row; i++) {
                int count = 0;
                for (int j = 0; j < col; j++) {
                    flip[j] = 1 ^ matrix[i][j];
                }

                for (int k = 0; k < row; k++) {
                    if (Arrays.equals(matrix[i], matrix[k]) || Arrays.equals(flip, matrix[k])) {
                        count++;
                    }
                }
                result = Math.max(result, count);
            }

            return result;
        }
    }
}