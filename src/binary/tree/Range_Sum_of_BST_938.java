package binary.tree;

public class Range_Sum_of_BST_938 {
    class Solution {
        public int rangeSumBST(TreeNode root, int L, int R) {
            return dfs(root, L, R);
        }

        private int dfs(TreeNode root, int L, int R) {
            int result = 0;

            if (root == null) {
                return result;
            }

            if (root.val < L) {
                result += dfs(root.right, L, R);
            } else if (root.val > R) {
                result += dfs(root.left, L, R);
            } else {
                result += root.val;
                result += dfs(root.left, L, R);
                result += dfs(root.right, L, R);
            }

            return result;
        }
    }
}
