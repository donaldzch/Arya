package binary.tree;

public class Binary_Tree_Maximum_Path_Sum_124 {
    class Solution {
        public int maxPathSum(TreeNode root) {
            int[] maxSum = new int[1];
            maxSum[0] = Integer.MIN_VALUE;
            maxPathSumRecursive(root, maxSum);
            return maxSum[0];
        }

        private int maxPathSumRecursive(TreeNode root, int[] maxSum) {
            if (root == null)
                return 0;

            int left = Math.max(0, maxPathSumRecursive(root.left, maxSum));
            int right = Math.max(0, maxPathSumRecursive(root.right, maxSum));

            maxSum[0] = Math.max(maxSum[0], left + right + root.val);

            return Math.max(left, right) + root.val;
        }
    }
}
