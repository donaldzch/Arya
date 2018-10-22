package binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N_ary_Tree_Level_Order_Traversal_429 {
    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> ans = new ArrayList<>();

            if (root == null)
                return ans;

            Queue<Node> queue = new LinkedList<>();

            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();

                List<Integer> res = new ArrayList<>();

                for (int i = 0; i < size; i++) {
                    Node cur = queue.poll();

                    if (cur.children != null) {
                        for (Node child : cur.children) {
                            queue.offer(child);
                        }
                    }

                    res.add(cur.val);
                }

                ans.add(res);
            }

            return ans;
        }
    }

    class Solution1 {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> ans = new ArrayList<>();
            levelOrder(root, 0, ans);
            return ans;
        }

        private void levelOrder(Node root, int depth, List<List<Integer>> ans) {
            if (root == null)
                return;

            if (depth >= ans.size()) {
                ans.add(new ArrayList<>());
            }

            ans.get(depth).add(root.val);


            if (root.children != null) {
                for (Node child : root.children) {
                    levelOrder(child, depth + 1, ans);
                }
            }
        }
    }
}
