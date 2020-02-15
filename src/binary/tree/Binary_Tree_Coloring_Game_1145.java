package binary.tree;

class Binary_Tree_Coloring_Game_1145 {
    class Solution {
        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
            int[] counts = new int[2];
            int total = count(root, x, counts);
            int left = counts[0];
            int right = counts[1];
            int parent = total - left - right - 1;
            if (parent > 1 + left + right) {
                return true;
            }
            if (left > 1 + parent + right) {
                return true;
            }
            if (right > 1 + parent + left) {
                return true;
            }
            return false;
        }

        private int count(TreeNode node, int x, int[] counts) {
            if (node == null) {
                return 0;
            }
            int left = count(node.left, x, counts);
            int right = count(node.right, x, counts);

            if (node.val == x) {
                counts[0] = left;
                counts[1] = right;
            }
            return 1 + left + right;
        }
    }
}