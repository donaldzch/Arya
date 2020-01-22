package dfs;

class Number_of_Enclaves_1020 {
    class Solution {
        public int numEnclaves(int[][] A) {
            int count = 0;
            int row = A.length;
            int col = A[0].length;

            for (int i = 0; i < row; i++) {
                dfs(A, i, 0);
                dfs(A, i, col - 1);
            }

            for (int j = 0; j < col; j++) {
                dfs(A, 0, j);
                dfs(A, row - 1, j);
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (A[i][j] == 1) {
                        count++;
                    }
                }
            }

            return count;
        }

        private void dfs(int[][] A, int i, int j) {
            if (i < 0 || i >= A.length || j < 0 || j >= A[0].length) {
                return;
            }

            if (A[i][j] == 0) {
                return;
            }

            A[i][j] = 0;
            dfs(A, i + 1, j);
            dfs(A, i - 1, j);
            dfs(A, i, j + 1);
            dfs(A, i, j - 1);
        }
    }
}