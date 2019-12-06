package matrix.operation;

public class Projection_Area_of_3D_Shapes_883 {
    class Solution {
        public int projectionArea(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;

            int result = 0;

            for (int i = 0; i < row; i++) {
                int max_row = 0, max_col = 0;
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] > 0)
                        result++;
                    max_row = Math.max(max_row, grid[i][j]);
                    max_col = Math.max(max_col, grid[j][i]);
                }
                result += max_row + max_col;
            }
            return result;
        }
    }
}
