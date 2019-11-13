package binary.tree;

public class Distribute_Coins_in_Binary_Tree_979 {
    class Solution {

        private int moves = 0;

        public int distributeCoins(TreeNode root) {
            dfs(root);
            return moves;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = dfs(root.left);
            int right = dfs(root.right);

            moves += Math.abs(left) + Math.abs(right);

            return root.val + left + right - 1;
        }
    }
}
