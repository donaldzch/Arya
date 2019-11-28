package math.operation;

class Check_If_It_Is_a_Straight_Line_1232 {
    class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            int x1 = coordinates[0][0], y1 = coordinates[0][1];
            int x2 = coordinates[1][0], y2 = coordinates[1][1];
            for (int i = 2; i < coordinates.length; i++) {
                int[] coordinate = coordinates[i];
                if ((coordinate[1] - y1) * (coordinate[0] - x2) != (coordinate[1] - y2) * (coordinate[0] - x1)) {
                    return false;
                }
            }
            return true;
        }
    }
}