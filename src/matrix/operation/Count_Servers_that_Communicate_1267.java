package matrix.operation;

class Count_Servers_that_Communicate_1267 {
    class Solution {
        public int countServers(int[][] grid) {
            int result = 0;

            int r = grid.length;
            int c = grid[0].length;

            int[] rows = new int[r];
            int[] cols = new int[c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (grid[i][j] == 1) {
                        rows[i]++;
                        cols[j]++;
                    }
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (grid[i][j] == 1 && (rows[i] > 1 || cols[j] > 1)) {
                        result++;
                    }
                }
            }
            return result;
        }
    }
}