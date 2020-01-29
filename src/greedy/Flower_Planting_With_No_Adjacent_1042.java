package greedy;

import java.util.*;

class Flower_Planting_With_No_Adjacent_1042 {
    class Solution {
        public int[] gardenNoAdj(int N, int[][] paths) {
            int[] result = new int[N];
            Map<Integer, Set<Integer>> graph = new HashMap<>();

            for (int i = 0; i < N; i++) {
                graph.put(i, new HashSet<>());
            }

            for (int[] path : paths) {
                graph.get(path[0] - 1).add(path[1] - 1);
                graph.get(path[1] - 1).add(path[0] - 1);
            }

            for (int i = 0; i < N; i++) {
                int[] color = new int[5];

                for (int adj : graph.get(i)) {
                    color[result[adj]] = 1;
                }

                for (int c = 4; c > 0; c--) {
                    if (color[c] == 0) {
                        result[i] = c;
                    }
                }
            }

            return result;
        }
    }
}