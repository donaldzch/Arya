package binary.tree;

public class Longest_Univalue_Path_687 {
    public int longestUnivaluePath(TreeNode root) {
        int[] result = new int[1];
        dfs(root, result);
        return result[0];
    }

    private int dfs(TreeNode node, int[] result) {
        if (node == null)
            return 0;
        int left = dfs(node.left, result);
        int right = dfs(node.right, result);

        int resultLeft = 0, resultRight = 0;
        if (node.left != null && node.left.val == node.val) {
            resultLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            resultRight += right + 1;
        }
        result[0] = Math.max(result[0], resultLeft + resultRight);
        return Math.max(resultLeft, resultRight);

    }
}
