package binary.tree;

import java.util.Stack;

public class Validate_Binary_Search_Tree_98 {
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }

        private boolean isValidBST(TreeNode root, Integer min, Integer max) {
            if (root == null)
                return true;

            if ((min != null && root.val <= min) || (max != null && root.val >= max))
                return false;

            return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
        }
    }

    class Solution1 {
        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode prev = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }

                root = stack.pop();
                if (prev != null && prev.val >= root.val)
                    return false;

                prev = root;
                root = root.right;

            }
            return true;
        }
    }
}
