package array.operation;

class Distance_Between_Bus_Stops_1184 {
    class Solution {
        public int distanceBetweenBusStops(int[] distance, int start, int destination) {
            int n = distance.length;

            int counterwise = 0;

            for (int i = start; i != destination; i = (i + 1) % n) {
                counterwise += distance[i];
            }

            int antiCounter = 0;
            for (int i = destination; i != start; i = (i + 1) % n) {
                antiCounter += distance[i];
            }
            return Math.max(couterwise, antiCounter);
        }
    }

    class Solution1 {
        public int distanceBetweenBusStops(int[] distance, int start, int destination) {
            int temp;

            if (start > destination) {
                temp = destination;
                destination = start;
                start = temp;
            }

            int total = 0, result = 0;

            for (int i = 0; i < distance.length; i++) {
                if (i >= start && i < destination) {
                    result += distance[i];
                }
                total += distance[i];
            }

            return Math.min(result, total - result);
        }
    }
}