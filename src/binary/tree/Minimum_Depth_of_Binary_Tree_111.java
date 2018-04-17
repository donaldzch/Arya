package binary.tree;

public class Minimum_Depth_of_Binary_Tree_111 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        return (root.left == null || root.right == null) ? Math.max(leftDepth, rightDepth) + 1 : Math.min(leftDepth, rightDepth) + 1;
    }
}
