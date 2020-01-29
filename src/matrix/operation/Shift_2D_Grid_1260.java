package matrix.operation;

import java.util.*;

class Shift_2D_Grid_1260 {
    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            int n = grid.length;
            int m = grid[0].length;


            Integer[][] temp = new Integer[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int index = i * n + j + k;
                    int row = (index / m) % n;
                    int col = index % m;
                    temp[row][col] = grid[i][j];
                }
            }
            
            List<List<Integer>> res = new ArrayList<>();

            for(int i = 0; i < k; i++){
                res.add(Arrays.asList(temp[i]));
            }
            return res;
        }
    }
}