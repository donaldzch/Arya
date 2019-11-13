package dfs;

import java.io.IOException;

public class Surrounded_Regions_130 {
    class Solution {
        public void solve(char[][] board) {
            if (board == null || board.length == 0 || board[0].length == 0) {
                return;
            }
            int row = board.length;
            int col = board[0].length;
            boolean[][] visited = new boolean[row][col];
            for (int j = 0; j < col; j++) {
                if (!visited[0][j]) {
                    dfs(board, visited, 0, j, row, col, false);
                }
                if (!visited[row - 1][j]) {
                    dfs(board, visited, row - 1, j, row, col, false);
                }
            }
            for (int i = 0; i < row; i++) {
                if (!visited[i][0]) {
                    dfs(board, visited, i, 0, row, col, false);
                }
                if (!visited[i][col - 1]) {
                    dfs(board, visited, i, col - 1, row, col, false);
                }
            }

            for (int i = 1; i < row - 1; i++) {
                for (int j = 1; j < col - 1; j++) {
                    if (!visited[i][j]) {
                        dfs(board, visited, i, j, row, col, true);
                    }
                }
            }
        }

        private void dfs(char[][] board, boolean[][] visited, int i, int j, int row, int col, boolean change) {
            if (i < 0 || i >= row || j < 0 || j >= col)
                return;
            if (visited[i][j]) {
                return;
            }
            if (board[i][j] == 'X') {

                visited[i][j] = true;
                return;
            }
            if (change) {
                board[i][j] = 'X';
            }
            visited[i][j] = true;
            dfs(board, visited, i + 1, j, row, col, change);
            dfs(board, visited, i - 1, j, row, col, change);
            dfs(board, visited, i, j + 1, row, col, change);
            dfs(board, visited, i, j - 1, row, col, change);
        }
    }

    public static void main(String[] args) throws IOException {

        char[][] board = {{'X'}};
        new Surrounded_Regions_130().new Solution().solve(board);


    }
}
