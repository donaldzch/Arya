package matrix.operation;

class Spiral_Matrix_II_59 {
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] dirs = {{0, 1}, {1, 0}, {0 , -1}, {-1, 0}};

            int length = n;

            int size = n * n;

            int index = 0;

            int dir = 0;

            int row = 0;
            int col = -1;

            int[][] result = new int[n][n];

            while (index < size) {
                if (dir == 1 || dir == 3) {
                    length--;
                }
                for (int i = 0; i < length; i++) {
                    row += dirs[dir][0];
                    col += dirs[dir][1]; 
                    result[row][col] = ++index;
                }
                dir = (dir + 1) % 4;
            }

            return result;
        }
    }
}