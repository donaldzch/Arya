package binary.tree;

public class Delete_Node_in_a_BST_450 {
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null)
                return null;

            if (root.val == key) {
                if (root.left == null)
                    return root.right;
                if (root.right == null)
                    return root.left;

                TreeNode min = root.right;
                while (min.left != null) {
                    min = min.left;
                }
                root.val = min.val;
                root.right = deleteNode(root.right, root.val);

            } else if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else {
                root.right = deleteNode(root.right, key);
            }

            return root;
        }
    }
}
