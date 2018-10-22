package binary.tree;

public class Binary_Tree_Pruning_814 {
    class Solution {
        public TreeNode pruneTree(TreeNode root) {
            return containOne(root) ? root : null;
        }

        private boolean containOne(TreeNode root) {
            if (root == null)
                return false;

            boolean leftContain = containOne(root.left);
            boolean rightContain = containOne(root.right);

            if (!leftContain) root.left = null;
            if (!rightContain) root.right = null;

            return root.val == 1 || leftContain || rightContain;
        }
    }
}
