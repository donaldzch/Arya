package dfs;

import java.util.*;

public class Network_Delay_Time_743 {
    class Solution {
        public int networkDelayTime(int[][] times, int N, int K) {
            Map<Integer, Integer> distance = new HashMap<>();
            Map<Integer, List<int[]>> graph = new HashMap<>();

            for (int[] time : times) {
                if (!graph.containsKey(time[0])) {
                    graph.put(time[0], new ArrayList<>());
                }
                graph.get(time[0]).add(new int[]{time[2], time[1]});
            }

            for (int node = 1; node <= N; node++) {
                distance.put(node, Integer.MAX_VALUE);
            }

            dfs(graph, K, 0, distance);

            int result = 0;
            for (int node : distance.keySet()) {
                if (distance.get(node) == Integer.MAX_VALUE)
                    return -1;
                result = Math.max(result, distance.get(node));
            }
            return result;
        }

        private void dfs(Map<Integer, List<int[]>> graph, int node, int elapsed, Map<Integer, Integer> distance) {
            if (elapsed >= distance.get(node))
                return;
            distance.put(node, elapsed);
            if (graph.containsKey(node)) {
                for (int[] time : graph.get(node)) {
                    dfs(graph, time[1], elapsed + time[0], distance);
                }
            }
        }
    }

    class Solution1 {
        //Bellman Ford Single source
        public int networkDelayTime(int[][] times, int N, int K) {
            Map<Integer, Integer> distance = new HashMap<>();

            for (int i = 1; i <= N; i++) {
                distance.put(i, Integer.MAX_VALUE);
            }

            distance.put(K, 0);

            for (int i = 0; i < N - 1; i++) {
                for (int[] time : times) {
                    int u = time[0];
                    int v = time[1];
                    int w = time[2];

                    if (distance.get(u) != Integer.MAX_VALUE
                            && distance.get(v) > distance.get(u) + w) {
                        distance.put(v, distance.get(u) + w);
                    }
                }
            }

            int delay = 0;
            for (Integer d : distance.values()) {
                if (d == Integer.MAX_VALUE)
                    return -1;
                delay = Math.max(d, delay);
            }
            return delay;
        }
    }

    class Solution2 {
        private class Node {
            private int key;
            private int value;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public int getKey() {
                return this.key;
            }

            public int getValue() {
                return this.value;
            }
        }

        //Djikstra Single source
        public int networkDelayTime(int[][] times, int N, int K) {
            Map<Integer, Map<Integer, Integer>> graph = buildGraph(times, N);
            Map<Integer, Integer> distance = new HashMap<>();

            PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(Node::getValue));
            queue.offer(new Node(K, 0));

            while (!queue.isEmpty()) {
                Node current = queue.poll();

                // Ignore processed nodes
                if (distance.containsKey(current.getKey())) {
                    continue;
                }

                distance.put(current.getKey(), current.getValue());

                Map<Integer, Integer> edges = graph.get(current.getKey());

                for (Map.Entry<Integer, Integer> edge : edges.entrySet()) {
                    int adjacent = edge.getKey();
                    int newDistance = current.getValue() + edge.getValue();
                    // Ignore processed nodes
                    if (distance.containsKey(adjacent)
                            && distance.get(adjacent) <= newDistance) {
                        continue;
                    }
                    queue.add(new Node(adjacent, newDistance));
                }
            }

            int delay = 0;
            for (Integer d : distance.values()) {
                delay = Math.max(d, delay);
            }
            return distance.size() == N ? delay : -1;
        }

        private Map<Integer, Map<Integer, Integer>> buildGraph(int[][] times, int N) {
            Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
            for (int i = 1; i <= N; i++) {
                graph.put(i, new HashMap<>());
            }
            for (int[] time : times) {
                graph.get(time[0]).put(time[1], time[2]);
            }
            return graph;
        }
    }

    public static void main(String[] args) throws Exception {
        int[][] times = {
                {1, 2, 1}, {2, 3, 2}, {1, 3, 2}
        };
        int N = 3;
        int K = 1;
        new Network_Delay_Time_743().new Solution2().networkDelayTime(times, N, K);
    }
}
