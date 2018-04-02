package binary.tree;

public class Sum_of_Left_Leaves_404 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null)
            return sum;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null)
                sum += root.left.val;
            else
                sum += sumOfLeftLeaves(root.left);
        }
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
}
