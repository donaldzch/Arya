package binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Find_Bottom_Left_Tree_Value_513 {
    class Solution {
        public int findBottomLeftValue(TreeNode root) {
            int[] res = new int[]{0, 0};

            return dfs(root, 1, res);
        }

        private int dfs(TreeNode root, int depth, int[] res) {
            if (res[1] < depth) {
                res[0] = root.val;
                res[1] = depth;
            }

            if (root.left != null)
                dfs(root.left, depth + 1, res);
            if (root.right != null)
                dfs(root.right, depth + 1, res);

            return res[0];
        }
    }

    class Solution1 {
        public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            TreeNode cur = null;

            while (!queue.isEmpty()) {
                cur = queue.poll();

                if (cur.right != null) {
                    queue.offer(cur.right);
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
            }

            return cur.val;
        }
    }
}
