package binary.tree;

class Sum_of_Nodes_with_Even_Valued_Grandparent_1315 {
    class Solution {
        public int sumEvenGrandparent(TreeNode root) {
            return dfs(root, 1, 1);
        }

        private int dfs(TreeNode node, int parent, int grandparent) {
            if (node == null) {
                return 0;
            }
            return dfs(node.left, node.val, parent) + dfs(node.right, node.val, parent) + (grandparent % 2 == 0 ? node.val : 0);
        }
    }
}