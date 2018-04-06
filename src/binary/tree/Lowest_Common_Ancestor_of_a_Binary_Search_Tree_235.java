package binary.tree;

public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (p.val < root.val && q.val < root.val)
                root = root.left;
            else if (p.val > root.val && q.val > root.val)
                root = root.right;
            else
                break;
        }
        return root;
    }
}
