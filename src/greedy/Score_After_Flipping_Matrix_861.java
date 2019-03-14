package greedy;

public class Score_After_Flipping_Matrix_861 {
    class Solution {
        public int matrixScore(int[][] A) {
            int result;
            int row = A.length;
            int col = A[0].length;

            result = (1 << (col - 1)) * row;

            for (int j = 1; j < col; j++) {
                int count = 0;
                for (int i = 0; i < row; i++) {
                    count += A[i][j] == A[i][0] ? 1 : 0;
                }
                result += Math.max(count, row - count) * (1 << (col - 1 - j));
            }


            return result;
        }
    }
}
