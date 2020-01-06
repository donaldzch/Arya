package matrix.operation;

class Spiral_Matrix_III_885 {
    class Solution {
        public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
            int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int length = 0, dir = 0;

            int index = 0;

            int[][] result = new int[R * C][2];
            result[index++] = new int[] {r0, c0};

            while (index < R * C) {
                if (dir == 0 || dir == 2) {
                    length++;
                }
                for (int i = 0; i < length; i++) {
                    r0 += dirs[dir][0];
                    c0 += dirs[dir][1];
                    if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) {
                        result[index++] = new int[] {r0, c0};
                    }
                }
                dir = (dir + 1) % 4;
            }

            return result;
        }
    }
}