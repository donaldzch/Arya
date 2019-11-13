package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find_Eventual_Safe_States_802 {
    class Solution {

        public List<Integer> eventualSafeNodes(int[][] graph) {
            List<Integer> result = new ArrayList<>();

            int[] statuses = new int[graph.length];

            Arrays.fill(statuses, 0);

            for (int i = 0; i < graph.length; i++) {
                if (!hasCycle(graph, i, statuses)) {
                    result.add(i);
                }
            }

            return result;
        }

        private boolean hasCycle(int[][] graph, int node, int[] statuses) {
            if (statuses[node] != 0)
                return statuses[node] == 1;

            statuses[node] = 1;

            for (int adjacent : graph[node]) {
                if (hasCycle(graph, adjacent, statuses)) {
                    return true;
                }
            }

            statuses[node] = 2;
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        new Find_Eventual_Safe_States_802().new Solution().eventualSafeNodes(graph);
    }
}
