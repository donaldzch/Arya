package binary.tree;

public class Search_in_a_Binary_Search_Tree_700 {
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) {
                return null;
            }

            if (root.val == val) {
                return root;
            } else if (root.val < val) {
                return searchBST(root.right, val);
            } else {
                return searchBST(root.left, val);
            }

        }
    }

    class Solution1 {
        public TreeNode searchBST(TreeNode root, int val) {
            TreeNode node = root;

            while (node != null) {
                if (node.val == val) {
                    break;
                } else if (node.val < val) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            }

            return node;
        }
    }
}
