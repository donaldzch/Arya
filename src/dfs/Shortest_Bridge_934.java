package dfs;

import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Bridge_934 {
    class Solution {
        public int shortestBridge(int[][] A) {
            int row = A.length;
            int col = A[0].length;
            boolean[][] visited = new boolean[row][col];
            Queue<int[]> queue = new LinkedList<>();
            boolean found = false;

            for (int i = 0; i < row; i++) {
                if (found) {
                    break;
                }
                for (int j = 0; j < col; j++) {
                    if (A[i][j] == 1) {
                        dfs(A, i, j, visited, queue);
                        found = true;
                        break;
                    }
                }
            }

            int bridge = 0;
            int[][] directions = {
                    {1, 0}, {-1, 0}, {0, 1}, {0, -1}
            };

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int s = 0; s < size; s++) {
                    int[] current = queue.poll();

                    for (int[] direction : directions) {
                        int i = current[0] + direction[0];
                        int j = current[1] + direction[1];
                        if (i >= 0 && i < row && j >= 0 && j < col && !visited[i][j]) {
                            if (A[i][j] == 1) {
                                return bridge;
                            }
                            visited[i][j] = true;
                            queue.offer(new int[]{i, j});
                        }

                    }
                }
                bridge++;
            }

            return -1;
        }

        private void dfs(int[][] A, int i, int j, boolean[][] visited, Queue<int[]> queue) {
            int row = A.length;
            int col = A[0].length;

            if (i < 0 || j < 0 || i >= row || j >= col || visited[i][j] || A[i][j] == 0) {
                return;
            }

            visited[i][j] = true;
            queue.offer(new int[]{i, j});
            dfs(A, i - 1, j, visited, queue);
            dfs(A, i + 1, j, visited, queue);
            dfs(A, i, j - 1, visited, queue);
            dfs(A, i, j + 1, visited, queue);
        }
    }
}
