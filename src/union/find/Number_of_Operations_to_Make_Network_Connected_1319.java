package union.find;

import java.util.*;

class Number_of_Operations_to_Make_Network_Connected_1319 {
    class Solution {
        public int makeConnected(int n, int[][] connections) {
            if (connections.length < n - 1) return -1;
            int components = n;

            int[] parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }

            for (int[] connection : connections) {
                int p1 = findParent(parents, connection[0]);
                int p2 = findParent(parents, connection[1]);

                if (p1 != p2) {
                    parents[p1] = p2;
                    components--;
                }
            }

            return components - 1;
        }

        private int findParent(int[] parents, int i) {
            if (parents[i] != i) {
                parents[i] = findParent(parents, parents[i]);
            }
            return parents[i];
        }
    }

    class Solution1 {
        public int makeConnected(int n, int[][] connections) {
            if (connections.length < n - 1) {
                return -1;
            }
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int[] connection : connections) {
                if (!graph.containsKey(connection[0])) {
                    graph.put(connection[0], new ArrayList<>());
                }
                if (!graph.containsKey(connection[1])) {
                    graph.put(connection[1], new ArrayList<>());
                }
                graph.get(connection[0]).add(connection[1]);
                graph.get(connection[1]).add(connection[0]);
            }

            boolean[] visited = new boolean[n];
            int components =0;
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    dfs(graph, visited, v);
                    components++;
                }
            }
            return components - 1;
        }

        private void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int vertex) {
            if (visited[vertex]) {
                return;
            }
            visited[vertex] = true;

            if (graph.get(vertex) != null) {
                for (int u : graph.get(vertex)) {
                    dfs(graph, visited, u);
                }
            }
        }
    }
}