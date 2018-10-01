package binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Right_Side_View_199 {
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();

            if (root == null)
                return ans;

            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    if (i == 0)
                        ans.add(cur.val);
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                }
            }
            return ans;
        }
    }

    class Solution1 {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            dfs(root, ans, 0);
            return ans;
        }

        private void dfs(TreeNode root, List<Integer> ans, int depth) {
            if (root == null)
                return;

            if (ans.size() == depth) {
                ans.add(root.val);
            }

            dfs(root.right, ans, depth + 1);
            dfs(root.left, ans, depth + 1);
        }
    }
}
