package binary.tree;

public class Balanced_Binary_Tree_110 {
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode node) {
        if (node == null)
            return 0;

        int leftDepth = depth(node.left);
        if (leftDepth == -1)
            return -1;
        int rightDepth = depth(node.right);
        if (rightDepth == -1)
            return -1;

        if (Math.abs(leftDepth - rightDepth) > 1)
            return -1;

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
