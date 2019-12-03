package math.operation;

class Valid_Boomerang_1037 {
    class Solution {
        public boolean isBoomerang(int[][] points) {
            int x0 = points[0][0], y0 = points[0][1], x1 = points[1][0], y1 = points[1][1];

            for (int i = 2; i < points.length; i++) {
                if ((y0 - y1) * (points[i][0] - x0) == (x0 - x1) * (points[i][1] - y0)) {
                    return false;
                }
            }
            return true;
        }
    }
}