package dfs;

public class Minesweeper_529 {
    class Solution {
        public char[][] updateBoard(char[][] board, int[] click) {
            update(board, click[0], click[1]);
            return board;
        }

        private void update(char[][] board, int x, int y) {
            int row = board.length;
            int col = board[0].length;

            if (x < 0 || x >= row || y < 0 || y >= col) {
                return;
            }

            if (board[x][y] == 'M') {
                board[x][y] = 'X';
            }

            if (board[x][y] == 'E') {
                int num = mineNumber(board, x, y);

                if (num == 0) {
                    board[x][y] = 'B';
                    for (int[] direction : directions) {
                        update(board, x + direction[0], y + direction[1]);
                    }
                } else {
                    board[x][y] = (char) (num + '0');
                }
            }

        }

        private int[][] directions = new int[][]{
                {1, 0}, {1, -1}, {1, 1},
                {-1, 0}, {-1, -1}, {-1, 1},
                {0, -1}, {0, 1}
        };

        private int mineNumber(char[][] board, int x, int y) {
            int row = board.length;
            int col = board[0].length;

            int result = 0;
            for (int[] direction : directions) {
                int new_x = x + direction[0];
                int new_y = y + direction[1];
                if (new_x < 0 || new_x >= row || new_y < 0 || new_y >= col) {
                    continue;
                }
                if (board[new_x][new_y] == 'M') {
                    result++;
                }
            }
            return result;
        }
    }
}
