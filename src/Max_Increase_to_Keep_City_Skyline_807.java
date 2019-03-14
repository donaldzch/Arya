public class Max_Increase_to_Keep_City_Skyline_807 {
    class Solution {
        public int maxIncreaseKeepingSkyline(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;

            int[] rowValues = new int[row];
            int[] colValues = new int[col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    rowValues[i] = Math.max(rowValues[i], grid[i][j]);
                    colValues[j] = Math.max(colValues[j], grid[i][j]);
                }
            }

            int result = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    result += Math.min(rowValues[i], colValues[j]) - grid[i][j];
                }
            }

            return result;
        }
    }
}
