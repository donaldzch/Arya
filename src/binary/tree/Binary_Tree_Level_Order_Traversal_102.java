package binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal_102 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();

            if (root == null)
                return ans;

            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            while (!queue.isEmpty()) {
                List<Integer> res = new ArrayList<>();
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    res.add(cur.val);

                    if (cur.left != null)
                        queue.offer(cur.left);

                    if (cur.right != null)
                        queue.offer(cur.right);
                }

                ans.add(res);
            }

            return ans;
        }
    }

    class Solution1 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            levelDFS(root, 0, ans);
            return ans;
        }

        private void levelDFS(TreeNode root, int depth, List<List<Integer>> ans) {
            if (root == null)
                return;

            if (depth >= ans.size()) {
                ans.add(new ArrayList<>());
            }

            ans.get(depth).add(root.val);

            levelDFS(root.left, depth + 1, ans);
            levelDFS(root.right, depth + 1, ans);
        }
    }
}
