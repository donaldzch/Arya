package binary.tree;

class Maximum_Difference_Between_Node_and_Ancestor_1026 {
    class Solution {
        public int maxAncestorDiff(TreeNode root) {
            return dfs(root, root.val, root.val);
        }

        private int dfs(TreeNode node, int max, int min) {
            if (node == null) {
                return max - min;
            }
            max = Math.max(max, node.val);
            min = Math.min(min, node.val);
            return Math.max(dfs(node.left, max, min), dfs(node.right, max, min));
        }
    }
}