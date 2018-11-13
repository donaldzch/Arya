package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pacific_Atlantic_Water_Flow_417 {

    class Solution {
        public List<int[]> pacificAtlantic(int[][] matrix) {
            List<int[]> ans = new ArrayList<>();

            if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
                return ans;

            int row = matrix.length;
            int col = matrix[0].length;

            boolean[][] pacific = new boolean[row][col];
            boolean[][] atlantic = new boolean[row][col];

            int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            for (int i = 0; i < row; i++) {
                dfs(matrix, pacific, directions, Integer.MIN_VALUE, i, 0);
                dfs(matrix, atlantic, directions, Integer.MIN_VALUE, i, col - 1);
            }

            for (int i = 0; i < col; i++) {
                dfs(matrix, pacific, directions, Integer.MIN_VALUE, 0, i);
                dfs(matrix, atlantic, directions, Integer.MIN_VALUE, row - 1, i);
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (pacific[i][j] && atlantic[i][j]) {
                        ans.add(new int[]{i, j});
                    }
                }
            }

            return ans;
        }

        private void dfs(int[][] matrix, boolean[][] visited, int[][] directions, int height, int m, int n) {
            int row = matrix.length;
            int col = matrix[0].length;

            if (m < 0 || m >= row || n < 0 || n >= col || visited[m][n] || height > matrix[m][n]) {
                return;
            }

            visited[m][n] = true;

            for (int[] direction : directions) {
                dfs(matrix, visited, directions, matrix[m][n], m + direction[0], n + direction[1]);
            }
        }
    }

    class Solution1 {
        public List<int[]> pacificAtlantic(int[][] matrix) {
            List<int[]> ans = new ArrayList<>();

            if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
                return ans;

            int row = matrix.length;
            int col = matrix[0].length;

            boolean[][] pacific = new boolean[row][col];
            boolean[][] atlantic = new boolean[row][col];

            Queue<int[]> pQueue = new LinkedList<>();
            Queue<int[]> aQueue = new LinkedList<>();

            for (int i = 0; i < row; i++) {
                pQueue.offer(new int[]{i, 0});
                pacific[i][0] = true;
                aQueue.offer(new int[]{i, col - 1});
                atlantic[i][col - 1] = true;
            }

            for (int j = 0; j < col; j++) {
                pQueue.offer(new int[]{0, j});
                pacific[0][j] = true;
                aQueue.offer(new int[]{row - 1, j});
                atlantic[row - 1][j] = true;
            }

            bfs(matrix, pQueue, pacific);
            bfs(matrix, aQueue, atlantic);

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (pacific[i][j] && atlantic[i][j]) {
                        ans.add(new int[]{i, j});
                    }
                }
            }

            return ans;
        }

        private void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {
            int row = matrix.length;
            int col = matrix[0].length;
            int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                for (int[] direction : directions) {
                    int m = cur[0] + direction[0];
                    int n = cur[1] + direction[1];

                    if (m < 0 || m >= row || n < 0 || n >= col || visited[m][n] || matrix[cur[0]][cur[1]] > matrix[m][n])
                        continue;

                    visited[m][n] = true;
                    queue.offer(new int[]{m, n});
                }
            }
        }
    }
}
