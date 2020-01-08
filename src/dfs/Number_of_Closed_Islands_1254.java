package dfs;

class Number_of_Closed_Islands_1254 {
    class Solution {
        public int closedIsland(int[][] grid) {
            int result = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
                        fill(grid, i, j);
                    }
                }
            }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 0) {
                        result++;
                        fill(grid, i, j);
                    }
                }
            }

            return result;
        }

        private void fill(int[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 1) {
                return;
            }
            grid[i][j] = 1;
            int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            for (int[] direction : directions) {
                fill(grid, i + direction[0], j + direction[1]);
            }
        }
    }
}