package binary.tree;

public class Add_One_Row_to_Tree_623 {
    class Solution {
        public TreeNode addOneRow(TreeNode root, int v, int d) {
            if (root == null) {
                return null;
            }

            if (d == 1) {
                TreeNode node = new TreeNode(v);
                node.left = root;
                return node;
            }

            addOneRow(root, v, d, 0);

            return root;
        }

        private void addOneRow(TreeNode root, int v, int d, int depth) {
            if (root == null) {
                return;
            }

            if (d - 1 == depth) {
                TreeNode left = new TreeNode(v);
                left.left = root.left;
                root.left = left;

                TreeNode right = new TreeNode(v);
                right.right = root.right;
                root.right = right;
            }

            addOneRow(root.left, v, d, depth + 1);
            addOneRow(root.right, v, d, depth + 1);
        }
    }

    class Solution1 {
        public TreeNode addOneRow(TreeNode root, int v, int d) {
            if (root == null) {
                return null;
            }

            if (d == 1) {
                TreeNode node = new TreeNode(v);
                node.left = root;
                return node;
            }


            if (d == 2) {
                TreeNode left = new TreeNode(v);
                left.left = root.left;
                root.left = left;

                TreeNode right = new TreeNode(v);
                right.right = root.right;
                root.right = right;
            }

            if (d > 2) {
                root.left = addOneRow(root, v, d - 1);
                root.right = addOneRow(root, v, d - 1);
            }

            return root;
        }
    }
}
