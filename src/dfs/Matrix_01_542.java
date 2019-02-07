package dfs;

import java.io.IOException;

public class Matrix_01_542 {
    class Solution {
        //DFS
        public int[][] updateMatrix(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            int[][] ans = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == 1 && !neighborZero(matrix, i, j)) {
                        ans[i][j] = Integer.MAX_VALUE;
                    } else {
                        ans[i][j] = matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (ans[i][j] == 1) {
                        update(ans, i, j, -1);
                    }
                }
            }

            return ans;
        }

        private int[][] directions = new int[][]{
                {1, 0}, {-1, 0},
                {0, 1}, {0, -1}
        };

        private void update(int[][] ans, int x, int y, int value) {
            if (x < 0 || x >= ans.length || y < 0 || y >= ans[0].length) {
                return;
            }

            if (ans[x][y] < value)
                return;

            if (value > 0)
                ans[x][y] = value;

            for (int[] direction : directions) {
                update(ans, x + direction[0], y + direction[1], ans[x][y] + 1);
            }
        }

        private boolean neighborZero(int[][] matrix, int x, int y) {
            int row = matrix.length;
            int col = matrix[0].length;

            if (x < 0 || x >= row || y < 0 || y >= col) {
                return false;
            }

            if (x + 1 < row && matrix[x + 1][y] == 0)
                return true;
            if (x - 1 >= 0 && matrix[x - 1][y] == 0)
                return true;
            if (y + 1 < col && matrix[x][y + 1] == 0)
                return true;
            if (y - 1 >= 0 && matrix[x][y - 1] == 0)
                return true;

            return false;
        }
    }

    class Solution1 {
        //DP
        public int[][] updateMatrix(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            int[][] ans = new int[row][col];
            int range = row * col;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    // top and left
                    if (matrix[i][j] == 0) {
                        ans[i][j] = 0;
                    } else {
                        int top = i > 0 ? ans[i - 1][j] : range;
                        int left = j > 0 ? ans[i][j - 1] : range;
                        ans[i][j] = Math.min(top, left) + 1;
                    }
                }
            }

            for (int i = row - 1; i >= 0; i--) {
                for (int j = col - 1; j >= 0; j--) {
                    // down and right
                    if (matrix[i][j] == 0) {
                        ans[i][j] = 0;
                    } else {
                        int down = i + 1 < row ? ans[i + 1][j] : range;
                        int right = j + 1 < col ? ans[i][j + 1] : range;
                        ans[i][j] = Math.min(Math.min(down, right) + 1, ans[i][j]);
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) throws IOException {

        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        int[][] ret = new Matrix_01_542().new Solution1().updateMatrix(matrix);
        System.out.print("done");
    }
}
