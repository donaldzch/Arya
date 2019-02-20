package dfs;

import java.util.*;

public class Accounts_Merge_721 {
    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, String> emailToName = new HashMap<>();
            Map<String, Set<String>> graph = buildGraph(accounts);

            for (List<String> account : accounts) {
                for (int i = 1; i < account.size(); i++) {
                    emailToName.put(account.get(i), account.get(0));
                }
            }

            List<List<String>> result = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            //traverse the graph
            for (String email : emailToName.keySet()) {
                if (visited.contains(email)) {
                    continue;
                }
                List<String> list = new LinkedList<>();
                dfs(graph, email, visited, list);
                Collections.sort(list);
                list.add(0, emailToName.get(email));
                result.add(list);
            }

            return result;
        }

        private void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> result) {
            if (visited.contains(email)) {
                return;
            }
            visited.add(email);
            result.add(email);
            for (String edge : graph.get(email)) {
                dfs(graph, edge, visited, result);
            }
        }

        private Map<String, Set<String>> buildGraph(List<List<String>> accounts) {
            Map<String, Set<String>> graph = new HashMap<>();

            for (List<String> account : accounts) {
                for (int i = 1; i < account.size(); i++) {
                    if (!graph.containsKey(account.get(i))) {
                        graph.put(account.get(i), new HashSet<>());
                    }
                    if (i == 1) {
                        continue;
                    }
                    graph.get(account.get(i)).add(account.get(i - 1));
                    graph.get(account.get(i - 1)).add(account.get(i));
                }
            }
            return graph;
        }
    }
}
