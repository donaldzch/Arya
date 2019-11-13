package binary.tree;

public class Maximum_Binary_Tree_II_998 {
    class Solution {
        public TreeNode insertIntoMaxTree(TreeNode root, int val) {
            if (root != null && root.val > val) {
                root.right = insertIntoMaxTree(root.right, val);
                return root;
            }
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
    }
}
