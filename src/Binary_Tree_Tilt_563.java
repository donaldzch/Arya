public class Binary_Tree_Tilt_563 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int findTilt(TreeNode root) {
        int[] result = new int[1];
        postOrder(root, result);
        return result[0];
    }

    private int postOrder(TreeNode node, int[] result) {
        if (node == null)
            return 0;
        int leftSum = postOrder(node.left, result);
        int rightSum = postOrder(node.right, result);
        result[0] += Math.abs(leftSum - rightSum);
        return node.val + leftSum + rightSum;
    }
}
