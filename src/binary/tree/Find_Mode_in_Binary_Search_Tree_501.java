package binary.tree;

public class Find_Mode_in_Binary_Search_Tree_501 {
    private int value;

    private int count = 0;

    private int maxCount = 0;

    private int mode;

    private int[] modes;

    public int[] findMode(TreeNode root) {
        inorder(root);

        modes = new int[mode];

        mode = 0;
        count = 0;
        inorder(root);
        return modes;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        execute(root);
        inorder(root.right);
    }

    private void execute(TreeNode root) {
        if (value == root.val) {
            count++;
        } else {
            value = root.val;
            count = 1;
        }
        if (modes == null) {
            if (count == maxCount) {
                mode++;
            } else if (count > maxCount) {
                mode = 1;
                maxCount = count;
            }
        } else {
            if (count == maxCount)
                modes[mode++] = root.val;
        }
    }
}
