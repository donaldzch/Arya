package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Possible_Bipartition_886 {
    class Solution {
        public boolean possibleBipartition(int N, int[][] dislikes) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int[] dislike : dislikes) {
                if (!graph.containsKey(dislike[0])) {
                    graph.put(dislike[0], new ArrayList<>());
                }
                if (!graph.containsKey(dislike[1])) {
                    graph.put(dislike[1], new ArrayList<>());
                }
                graph.get(dislike[0]).add(dislike[1]);
                graph.get(dislike[1]).add(dislike[0]);
            }

            int[] color = new int[N + 1];
            color[1] = 1;
            for (int i = 1; i <= N; i++) {
                if (!dfs(graph, i, color)) {
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(Map<Integer, List<Integer>> graph, int node, int[] color) {
            List<Integer> adjacents = graph.get(node);
            if (adjacents == null)
                return true;

            for (Integer adj : adjacents) {
                if (color[adj] == 0) {
                    color[adj] = color[node] == 1 ? -1 : 1;
                    if (!dfs(graph, adj, color)) {
                        return false;
                    }
                }
                if (color[adj] == color[node]) {
                    return false;
                }
            }
            return true;
        }
    }
}
