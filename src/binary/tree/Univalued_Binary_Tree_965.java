package binary.tree;

public class Univalued_Binary_Tree_965 {
    class Solution {
        public boolean isUnivalTree(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isUnivalTree(root, root.val);
        }

        private boolean isUnivalTree(TreeNode root, int value) {
            if (root == null)
                return true;
            return value == root.val && isUnivalTree(root.left, value) && isUnivalTree(root.right, value);
        }
    }
}
