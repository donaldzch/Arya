package binary.tree;

import java.util.Stack;

public class Path_Sum_112 {
    public class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null)
                return false;
            if (root.left == null && root.right == null && root.val == sum)
                return true;
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }

    public class Solution1 {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null)
                return false;
            Stack<TreeNode> stack = new Stack<>();
            Stack<Integer> sums = new Stack<>();

            stack.push(root);
            sums.push(sum);

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();

                int restSum = sums.pop();

                if (node.left == null && node.right == null && node.val == restSum)
                    return true;

                if (node.right != null) {
                    stack.push(node.right);
                    sums.push(restSum - node.val);
                }

                if (node.left != null) {
                    stack.push(node.left);
                    sums.push(restSum - node.val);
                }
            }
            return false;
        }
    }
}
