package matrix.operation;

import java.util.*;

class Minimum_Area_Rectangle_939 {
    class Solution {
        public int minAreaRect(int[][] points) {
            Map<Integer, Set<Integer>> map = new HashMap<>();

            for (int[] point : points) {
                if (!map.containsKey(point[0])) {
                    map.put(point[0], new HashSet<>());
                }
                map.get(point[0]).add(point[1]);
            }

            int result = Integer.MAX_VALUE;

            for(int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    if (points[i][0] == points[j][0] || points[i][1] == points[j][1]) {
                        continue;
                    }
                    if (map.get(points[i][0]).contains(points[j][1]) && map.get(points[j][0]).contains(points[i][1])) {
                        result = Math.min(result, Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1]));
                    }
                }
            }

            return result;
        }
    }
}