package binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Find_Largest_Value_in_Each_Tree_Row_515 {
    class Solution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> ans = new ArrayList<>();

            if (root == null)
                return ans;

            largestValues(root, 0, ans);

            return ans;
        }

        private void largestValues(TreeNode root, int depth, List<Integer> ans) {
            if (root == null)
                return;

            if (depth == ans.size()) {
                ans.add(root.val);
            } else {
                ans.set(depth, Math.max(root.val, ans.get(depth)));
            }

            largestValues(root.left, depth + 1, ans);
            largestValues(root.right, depth + 1, ans);
        }
    }

    class Solution1 {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> ans = new ArrayList<>();

            if (root == null)
                return ans;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                int value = Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();

                    value = Math.max(value, cur.val);

                    if (cur.left != null)
                        queue.offer(cur.left);
                    if (cur.right != null)
                        queue.offer(cur.right);
                }
                ans.add(value);
            }

            return ans;
        }
    }
}
