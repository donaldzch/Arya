package matrix.operation;

class Game_of_Life_289 {
    class Solution {
        public void gameOfLife(int[][] board) {
            int m = board.length;
            int n = board[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int liveNeightbors = getLiveNeightbor(board, m, n, i, j);

                    if (board[i][j] == 1 && liveNeightbors >= 2 && liveNeightbors <= 3) {
                        board[i][j] = 3;
                    }
                    if (board[i][j] == 0 && liveNeightbors == 3) {
                        board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] >>= 1;  // Get the 2nd state.
                }
            }
        }

        private int getLiveNeightbor(int[][] board, int m, int n, int i, int j) {
            int live = 0;

            for (int x = Math.max(0, i - 1); x <= Math.min(m - 1, i + 1); x++) {
                for (int y = Math.max(0, j - 1); y <= Math.min(n - 1, j + 1); y++) {
                    live += board[x][y] & 1;
                }
            }

            live -= board[i][j] & 1;
            return live;
        }
    }
}