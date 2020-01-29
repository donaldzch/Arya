package dfs;

import java.util.*;

public class Reconstruct_Itinerary_332 {
    class Solution {
        public List<String> findItinerary(String[][] tickets) {
            Map<String, PriorityQueue<String>> graph = new HashMap<>();
            buildGraph(tickets, graph);

            List<String> ans = new LinkedList<>();

            dfs("JFK", graph, ans);

            return ans;
        }

        private void buildGraph(String[][] tickets, Map<String, PriorityQueue<String>> graph) {
            for (String[] ticket : tickets) {
                if (!graph.containsKey(ticket[0])) {
                    graph.put(ticket[0], new PriorityQueue<>());
                }
                graph.get(ticket[0]).add(ticket[1]);
            }
        }

        //Hierholzer’s Algorithm for directed graph
        private void dfs(String vertex, Map<String, PriorityQueue<String>> graph, List<String> ans) {
            while (graph.containsKey(vertex) && !graph.get(vertex).isEmpty()) {
                dfs(graph.get(vertex).poll(), graph, ans);
            }
            ans.add(0, vertex);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String[][] tickets = {
                {"MUC", "LHR"},
                {"JFK", "MUC"},
                {"SFO", "SJC"},
                {"LHR", "SFO"}
        };

        new Reconstruct_Itinerary_332().new Solution().findItinerary(tickets);
    }

    class Solution1 {
        public List<String> findItinerary(String[][] tickets) {
            Map<String, PriorityQueue<String>> targets = new HashMap<>();
            for (String[] ticket : tickets)
                targets.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
            List<String> route = new LinkedList<>();
            Stack<String> stack = new Stack<>();
            stack.push("JFK");
            while (!stack.empty()) {
                while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
                    stack.push(targets.get(stack.peek()).poll());
                route.add(0, stack.pop());
            }
            return route;
        }
    }
}
