package binary.tree;

import java.util.*;

class Delete_Nodes_And_Return_Forest_1110 {
    class Solution {
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            Set<Integer> deleteSet = new HashSet<>();
            for (int delete : to_delete) {
                deleteSet.add(delete);
            }

            List<TreeNode> result = new ArrayList<>();
            if (!deleteSet.contains(root.val)) {
                result.add(root);
            }
            dfs(root, deleteSet, result);
            return result;
        }

        private TreeNode dfs(TreeNode node, Set<Integer> deleteSet, List<TreeNode> result) {
            if (node == null) {
                return null;
            }

            node.left = dfs(node.left, deleteSet, result);
            node.right = dfs(node.right, deleteSet, result);

            if (deleteSet.contains(node.val)) {
                if (node.left != null) {
                    result.add(node.left);
                }
                if (node.right != null) {
                    result.add(node.right);
                }
                return null;
            }
            return node;
        }
    }
}