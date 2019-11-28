package bfs;

import java.util.LinkedList;
import java.util.Queue;

class Rotting_Oranges_994 {
    class Solution {
        public int orangesRotting(int[][] grid) {
            Queue<int[]> queue = new LinkedList<int[]>();

            int row = grid.length;
            int col = grid[0].length;

            int fresh = 0;
            int minutes = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 2) {
                        queue.offer(new int[] {i, j});
                    }
                    if (grid[i][j] == 1) {
                        fresh++;
                    }
                }
            }

            if (fresh == 0) {
                return 0;
            }

            int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            while (!queue.isEmpty()) {
                minutes++;

                int size = queue.size();

                for (int k = 0; k < size; k++) {
                    int[] rotten = queue.poll();
                    for (int[] dir : dirs) {
                        int i = rotten[0] + dir[0];
                        int j = rotten[1] + dir[1];

                        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != 1) {
                            continue;
                        }
                        grid[i][j] = 2;
                        queue.offer(new int[] {i, j});
                        fresh--;
                    }
                }
            }

            return fresh == 0 ? --minutes : -1;
        }
    }
}