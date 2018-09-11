package binary.tree;

public class Flatten_Binary_Tree_to_Linked_List_114 {
    class Solution {
        public void flatten(TreeNode root) {
            TreeNode current = root;

            while (current != null) {
                if (current.left != null) {
                    TreeNode prev = current.left;

                    while (prev.right != null) {
                        prev = prev.right;
                    }
                    prev.right = current.right;

                    current.right = current.left;
                    current.left = null;
                }
                current = current.right;
            }
        }
    }

    class Solution1 {

        private TreeNode prev;

        public void flatten(TreeNode root) {
            if (root == null)
                return;

            flatten(root.right);
            flatten(root.left);

            root.right = prev;
            root.left = null;
            prev = root;
        }
    }
}
