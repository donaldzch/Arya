package stack.queue.operation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class K_Closest_Points_to_Origin_973 {
    class Solution {
        public int[][] kClosest(int[][] points, int K) {
            PriorityQueue<int[]> queue = new PriorityQueue<>(K, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] * o1[1] - o2[0] * o2[1];
                }
            });

            for (int[] point : points) {
                queue.offer(point);
            }

            int[][] result = new int[K][2];

            int i = 0;
            while (i < K) {
                result[i] = queue.poll();
                i++;
            }

            return result;
        }
    }

    class Solution1 {
        public int[][] kClosest(int[][] points, int K) {
            Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
            return Arrays.copyOfRange(points, 0, K);
        }
    }
}
