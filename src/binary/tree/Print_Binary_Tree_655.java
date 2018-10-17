package binary.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Print_Binary_Tree_655 {
    class Solution {
        public List<List<String>> printTree(TreeNode root) {
            List<List<String>> ans = new ArrayList<>();

            if (root == null) {
                return ans;
            }

            int row = getHeight(root);
            int col = (1 << row) - 1;

            String[][] res = new String[row][col];

            for (String[] str : res) {
                Arrays.fill(str, "");
            }

            fill(root, res, 0, 0, col - 1);

            for (String[] str : res) {
                ans.add(Arrays.asList(str));
            }

            return ans;
        }

        private void fill(TreeNode root, String[][] res, int row, int left, int right) {
            if (root == null)
                return;
            int col = (left + right) / 2;
            res[row][col] = String.valueOf(root.val);

            fill(root.left, res, row + 1, left, col - 1);
            fill(root.right, res, row + 1, col + 1, right);
        }

        private int getHeight(TreeNode root) {
            if (root == null)
                return 0;
            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        }
    }
}
