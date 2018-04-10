package binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Symmetric_Tree_101 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
    }

    public boolean isSymmetric1(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null)
                continue;
            if (left == null || right == null)
                return false;
            if (left.val != right.val)
                return false;
            queue.offer(left.right);
            queue.offer(right.left);
            queue.offer(left.left);
            queue.offer(right.right);
        }
        return true;
    }
}
