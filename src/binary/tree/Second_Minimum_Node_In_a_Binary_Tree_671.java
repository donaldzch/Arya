package binary.tree;

public class Second_Minimum_Node_In_a_Binary_Tree_671 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return -1;
        if (root.left == null && root.right == null)
            return -1;

        int left = (root.left != null && root.left.val != root.val) ? root.left.val : findSecondMinimumValue(root.left);
        int right = (root.right != null && root.right.val != root.val) ? root.right.val : findSecondMinimumValue(root.right);

        if (left == -1 || right == -1) return Math.max(left, right);

        return Math.min(left, right);
    }
}
