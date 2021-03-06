package binary.tree;

public class Convert_BST_to_Greater_Tree_538 {

    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;
        convert(root, 0);
        return root;
    }

    private int convert(TreeNode node, int sum) {
        if (node == null)
            return sum;
        node.val +=convert(node.right, sum);
        return convert(node.left, node.val);
    }
}
