package matrix.operation;

import java.util.LinkedList;
import java.util.Queue;

class Matrix_Cells_in_Distance_Order_1030 {
    class Solution {
        public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

            int[][] result = new int[R*C][2];

            Queue<int[]> queue = new LinkedList<>();

            boolean[][] visited = new boolean[R][C];

            queue.offer(new int[]{r0, c0});

            visited[r0][c0] = true;

            int count = R*C;

            for (int i = 0; i < count; i++) {
                int[] current = queue.poll();

                result[i] = current;

                if (current[0] + 1 < R && !visited[current[0] + 1][current[1]]) {
                    visited[current[0] + 1][current[1]] = true;
                    queue.offer(new int[] { current[0] + 1, current[1]});
                }
                if (current[0] - 1 >= 0 && !visited[current[0] - 1][current[1]]) {
                    visited[current[0] - 1][current[1]] = true;
                    queue.offer(new int[] { current[0] - 1, current[1]});
                }
                if (current[1] + 1 < C && !visited[current[0]][current[1] + 1]) {
                    visited[current[0]][current[1] + 1] = true;
                    queue.offer(new int[] { current[0], current[1] + 1});
                }
                if (current[1] - 1 >= 0 && !visited[current[0]][current[1] - 1]) {
                    visited[current[0]][current[1] - 1] = true;
                    queue.offer(new int[] { current[0], current[1] - 1});
                }
            }

            return result;
            
        }
    }
}