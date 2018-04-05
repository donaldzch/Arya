package binary.tree;

public class Subtree_of_Another_Tree_572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return s != null && (isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        return (s.val == t.val) && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

}
