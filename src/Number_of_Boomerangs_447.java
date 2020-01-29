import java.util.*;

class Number_of_Boomerangs_447 {
    class Solution {
        public int numberOfBoomerangs(int[][] points) {
            int result = 0;

            for (int i = 0; i < points.length; i++) {
                Map<Integer, Integer> distanceMap = new HashMap<>();
                for (int j = 0; j < points.length; j++) {
                    int distance = getDistance(points[i], points[j]);
                    distanceMap.put(distance, distanceMap.getOrDefault(distance, 0) + 1);
                }
                for (int count : distanceMap.values()) {
                    result += count * (count - 1);
                }
            }
            return result;
        }

        private int getDistance(int[] point1, int[] point2) {
            return (point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1]- point2[1]) * (point1[1] - point2[1]);
        }
    }
}