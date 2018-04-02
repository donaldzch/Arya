package binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Invert_Binary_Tree_226 {

    public TreeNode invertTree(TreeNode root) {
        if ( root == null) return null;
        final TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);

        while(!treeNodes.isEmpty()) {
            final TreeNode treeNode = treeNodes.poll();
            final TreeNode left = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = left;

            if (treeNode.left != null)
                treeNodes.offer(treeNode.left);
            if (treeNode.right != null)
                treeNodes.offer(treeNode.right);
        }
        return root;
    }
}
