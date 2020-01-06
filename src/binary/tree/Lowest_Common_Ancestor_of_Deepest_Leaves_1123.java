package binary.tree;

import java.util.HashMap;
import java.util.Map;

class Lowest_Common_Ancestor_of_Deepest_Leaves_1123 {
    class Solution {
        public TreeNode lcaDeepestLeaves(TreeNode root) {
            Map<TreeNode, Integer> map = new HashMap<>();           
            return dfs(root, map);
        }

        private TreeNode dfs(TreeNode root, Map<TreeNode, Integer> depthMap) {
            if (root == null) {
                return null;
            }
            int left = depth(root.left, depthMap);
            int right = depth(root.right, depthMap);
            if (left == right) {
                return root;
            }
            return dfs(left > right ? root.left : root.right, depthMap);
        }

        private int depth(TreeNode node, Map<TreeNode, Integer> depthMap) {
            if (node == null) {
                return 0;
            }
            if (depthMap.containsKey(node)) {
                return depthMap.get(node);
            }
            depthMap.put(node, 1 + Math.max(depth(node.left, depthMap), depth(node.right, depthMap)));
            return depthMap.get(node);
        }
    }
}