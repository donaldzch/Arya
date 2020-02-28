package union.find;

import java.util.*;

class Evaluate_Division_399 {

    class Node {
        String parent;
        Double weight;

        Node(String parent, Double weight) {
            this.parent = parent;
            this.weight = weight;
        }
    }
    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Map<String, Node> parents = new HashMap<>();
            Map<String, Integer> ranks = new HashMap<>();

            for (int i = 0; i < equations.size(); i++) {
                List<String> equation = equations.get(i);

                makeSet(equation.get(0), parents, ranks);
                makeSet(equation.get(1), parents, ranks);

                union(equation.get(0), equation.get(1), parents, ranks, values[i]);
            }

            double[] result = new double[queries.size()];
            for (int i = 0; i < queries.size(); i++) {
                List<String> query = queries.get(i);
                Node p1 = findSet(query.get(0), parents);
                Node p2 = findSet(query.get(1), parents);
                if (p1 == null || p2 == null) {
                    result[i] = -1.0;
                } else if(p1.parent.equals(p2.parent)) {
                    result[i] = p1.weight / p2.weight;
                } else {
                    result[i] = -1.0;
                }
            }
            return result;
        }

        private void makeSet(String node, Map<String, Node> parents, Map<String, Integer> ranks) {
            if (!parents.containsKey(node)) {
                parents.put(node, new Node(node, 1.0));
                ranks.put(node, 0);
            }
        }

        private Node findSet(String node, Map<String, Node> parents) {
            if (!parents.containsKey(node)) {
                return null;
            }
            if (!node.equals(parents.get(node).parent)) {
                Node parent = findSet(parents.get(node).parent, parents);
                parents.put(node, new Node(parent.parent, parent.weight *parents.get(node).weight));
            }
            return parents.get(node);
        }

        private void union(String node1, String node2, Map<String, Node> parents, Map<String, Integer> ranks, Double value) {
            Node parent1 = findSet(node1, parents);
            Node parent2 = findSet(node2, parents);

            if (parent1.parent.equals(parent2.parent)) {
                return;
            }

            int rank1 = ranks.get(parent1.parent);
            int rank2 = ranks.get(parent2.parent);

            if (rank1 < rank2) {
                parents.put(parent1.parent, new Node(parent2.parent, parent2.weight * value / parent1.weight));
            } else if (rank1 > rank2) {
                parents.put(parent2.parent, new Node(parent1.parent, parent1.weight / value / parent2.weight));
            } else {
                parents.put(parent1.parent, new Node(parent2.parent, parent2.weight * value / parent1.weight));
                ranks.put(parent2.parent, rank2++);
            }

        }
    }
}