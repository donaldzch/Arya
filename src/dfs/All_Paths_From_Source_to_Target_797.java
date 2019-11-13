package dfs;

import java.util.ArrayList;
import java.util.List;

public class All_Paths_From_Source_to_Target_797 {
    class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> path = new ArrayList<>();

            dfs(graph, 0, result, path);
            return result;
        }

        private void dfs(int[][] graph, int node, List<List<Integer>> result, List<Integer> path) {
            if (node == graph.length - 1) {
                path.add(node);
                result.add(new ArrayList<>(path));
                return;
            }

            for (int adj : graph[node]) {
                path.add(adj);
                dfs(graph, adj, result, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
