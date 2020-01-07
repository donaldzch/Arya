package dfs;

class Path_with_Maximum_Gold_1219 {
    class Solution {
        public int getMaximumGold(int[][] grid) {
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int row = grid.length;
            int col = grid[0].length;
            boolean[][] visited = new boolean[row][col];
            int result = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    result = Math.max(result, dfs(i, j, grid, visited, directions, 0));
                }
            }
            return result;
        }

        private int dfs(int i, int j, int[][] grid, boolean[][] visited, int[][] directions, int sum) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
                return sum;
            }
            if (visited[i][j]) {
                return sum;
            }
            sum += grid[i][j];
            visited[i][j] = true;

            int max = 0;
            for (int[] direction : directions) {
                max = Math.max(max, dfs(i + direction[0], j + direction[1], grid, visited, directions, sum));
            }
            visited[i][j] = false;

            return max;
        }
    }
}