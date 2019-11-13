package dfs;

public class Is_Graph_Bipartite_785 {
    class Solution {
        public boolean isBipartite(int[][] graph) {
            int[] groups = new int[graph.length];

            for (int i = 0; i < graph.length; i++) {
                if (groups[i] == 0 && !dfs(graph, i, 1, groups)) {
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(int[][] graph, int vertex, int group, int[] groups) {
            if (groups[vertex] != 0) {
                return groups[vertex] == group;
            }
            groups[vertex] = group;
            for (int edge : graph[vertex]) {
                if (!dfs(graph, edge, -group, groups)) {
                    return false;
                }
            }
            return true;
        }
    }
}
