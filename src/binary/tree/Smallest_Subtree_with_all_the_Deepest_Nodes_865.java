package binary.tree;

import javafx.util.Pair;

public class Smallest_Subtree_with_all_the_Deepest_Nodes_865 {
    class Solution {
        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            int[] maxDepth = new int[1];
            maxDepth[0] = -1;

            TreeNode[] ans = new TreeNode[1];

            dfs(root, 0, maxDepth, ans);

            return ans[0];
        }

        private int dfs(TreeNode root, int depth, int[] maxDepth, TreeNode[] ans) {
            if (root == null)
                return depth;

            int left = dfs(root.left, depth + 1, maxDepth, ans);
            int right = dfs(root.right, depth + 1, maxDepth, ans);

            if (left == right && left >= maxDepth[0]) {
                maxDepth[0] = left;
                ans[0] = root;
            }

            return Math.max(left, right);
        }
    }

    class Solution1 {
        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            return dfs(root).getValue();
        }

        private Pair<Integer, TreeNode> dfs(TreeNode root) {
            if (root == null)
                return new Pair<>(0, null);

            Pair<Integer, TreeNode> left = dfs(root.left);
            Pair<Integer, TreeNode> right = dfs(root.right);

            int depth = Math.max(left.getKey(), right.getKey()) + 1;

            TreeNode node = null;

            if (left.getKey().equals(right.getKey())) {
                node = root;
            } else if (left.getKey() > right.getKey()) {
                node = left.getValue();
            } else {
                node = right.getValue();
            }

            return new Pair<Integer, TreeNode>(depth, node);
        }
    }
}
