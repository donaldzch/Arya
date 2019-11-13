package dfs;

import java.util.*;

public class Loud_and_Rich_851 {
    class Solution {
        public int[] loudAndRich(int[][] richer, int[] quiet) {
            Map<Integer, List<Integer>> graph = new HashMap<>();

            for (int[] rich : richer) {
                if (!graph.containsKey(rich[1])) {
                    graph.put(rich[1], new ArrayList<>());
                }
                graph.get(rich[1]).add(rich[0]);
            }

            int[] result = new int[quiet.length];

            Arrays.fill(result, -1);

            for (int i = 0; i < quiet.length; i++) {
                dfs(graph, i, quiet, result);
            }

            return result;
        }

        private int dfs(Map<Integer, List<Integer>> graph, int vertex, int[] quiet, int[] result) {
            if (result[vertex] == -1) {
                result[vertex] = vertex;

                if (graph.get(vertex) != null) {
                    for (int adj : graph.get(vertex)) {
                        int adjacent = dfs(graph, adj, quiet, result);
                        if (quiet[adjacent] < quiet[result[vertex]]) {
                            result[vertex] = adjacent;
                        }
                    }
                }
            }
            return result[vertex];
        }
    }
}
