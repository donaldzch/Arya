package dfs;

import java.util.HashMap;
import java.util.Map;

public class Clone_Graph_133 {
    public class Solution {
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            return dfs(node, new HashMap<Integer, UndirectedGraphNode>());
        }

        private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
            if (node == null)
                return null;

            if (map.containsKey(node.label)) {
                return map.get(node.label);
            }
            UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
            map.put(clone.label, clone);

            for (UndirectedGraphNode neighbor : node.neighbors) {
                clone.neighbors.add(dfs(neighbor, map));
            }
            return clone;
        }
    }
}
