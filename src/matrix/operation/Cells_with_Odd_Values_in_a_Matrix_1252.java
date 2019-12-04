package matrix.operation;


class Cells_with_Odd_Values_in_a_Matrix_1252 {
    class Solution {
        public int oddCells(int n, int m, int[][] indices) {
            int[] rows = new int[n];
            int[] cols = new int[m];

            for (int[] indice : indices) {
                rows[indice[0]] ^= 1;
                cols[indice[1]] ^= 1;
            }

            int rowNum = 0;
            for (int row : rows) {
                if (row == 1) {
                    rowNum++;
                }
            }

            int colNum = 0;
            for (int col : cols) {
                if (col == 1) {
                    colNum++;
                }
            }

            return (m - colNum) * rowNum + (n - rowNum) * colNum;
        }
    }
}