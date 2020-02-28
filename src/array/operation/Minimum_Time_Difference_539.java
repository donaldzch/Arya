package array.operation;

import java.util.List;

class Minimum_Time_Difference_539 {
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            int result = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            boolean[] mark = new boolean[24 * 60];
            for (int i = 0; i < timePoints.size(); i++) {
                String timePoint = timePoints.get(i);
                String[] parts = timePoint.split(":");
                int hours = Integer.parseInt(parts[0]);
                int minutes = Integer.parseInt(parts[1]);

                int total = hours * 60 + minutes;
                if (mark[total]) {
                    return 0;
                }

                min = Math.min(min, total);
                max = Math.max(max, total);
                mark[total] = true;
            }

            int prev = 0;
            for (int i = min; i <= max; i++) {
                if (mark[i]) {
                    if (i == min) {
                        result = Math.min(result, Math.min(max - min, 1440 - max + min));
                    } else {
                        result = Math.min(result, i - prev);
                    }
                    prev = i;
                }
            }
            return result;
        }
    }
}