package binary.tree;

public class Flip_Equivalent_Binary_Trees_951 {
    class Solution {
        public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return true;
            }
            if (equal(root1, root2)) {
                TreeNode left1 = root1.left;
                TreeNode right1 = root1.right;
                TreeNode left2 = root2.left;
                TreeNode right2 = root2.right;

                if (equal(left1, left2) && equal(right1, right2)) {
                    return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
                } else if (equal(left1, right2) && equal(right1, left2)) {
                    return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
                }
            }

            return false;
        }

        private boolean equal(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return true;
            }
            if (root1 == null || root2 == null) {
                return false;
            }
            return root1.val == root2.val;
        }
    }

    class Solution1 {
        public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            if (root1 == null || root2 == null) {
                return root1 == root2;
            }
            if (root1.val != root2.val) {
                return false;
            }
            return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                    || (flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right));
        }
    }
}
