package graph.operation;

import java.util.*;

class Evaluate_Division_399 {
    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            double[] result = new double[queries.size()];

            Map<String, Map<String, Double>> graph = buildGraph(equations, values);

            for (int i = 0; i < queries.size(); i++) {
                List<String> query = queries.get(i);
                result[i] = dfs(graph, new HashSet<>(), query.get(0), query.get(1));
            }

            return result;
        }

        private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
            Map<String, Map<String, Double>> graph = new HashMap<>();

            for (int i = 0; i < equations.size(); i++) {
                List<String> equation = equations.get(i);
                graph.putIfAbsent(equation.get(0), new HashMap<>());
                graph.get(equation.get(0)).put(equation.get(0), 1.0);
                graph.get(equation.get(0)).put(equation.get(1), values[i]);
                graph.putIfAbsent(equation.get(1), new HashMap<>());
                graph.get(equation.get(1)).put(equation.get(1), 1.0);
                graph.get(equation.get(1)).put(equation.get(0), 1.0 / values[i]);
            }
            return graph;
        }

        private double dfs(Map<String, Map<String, Double>> graph, Set<String> visited, String v, String u) {
            if (!graph.containsKey(v) || !graph.containsKey(u)) {
                return -1.0;
            }

            if (graph.get(v).containsKey(u)) {
                return graph.get(v).get(u);
            }

            visited.add(v);

            for (Map.Entry<String, Double> neighbor : graph.get(v).entrySet()) {
                if (!visited.contains(neighbor.getKey())) {
                    double weight = dfs(graph, visited, neighbor.getKey(), u);
                    if (weight != -1.0) {
                        return neighbor.getValue() * weight;
                    }
                }
            }

            return -1.0;
        }
    }
}