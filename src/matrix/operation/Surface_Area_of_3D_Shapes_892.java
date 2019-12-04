package matrix.operation;

class Surface_Area_of_3D_Shapes_892 {
    class Solution {
        public int surfaceArea(int[][] grid) {
            int result = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] != 0) {
                        result += 4 * grid[i][j] + 2;
                    }
                    if (i != 0) {
                        result -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                    }
                    if (j != 0) {
                        result -= Math.min(grid[i][j], grid[i][j-1]) * 2;
                    }
                }
            }

            return result;
        }
    }
}