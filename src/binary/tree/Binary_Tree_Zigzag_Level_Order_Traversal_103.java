package binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Zigzag_Level_Order_Traversal_103 {
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();

            if (root == null)
                return ans;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            int level = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> levelNodes = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode current = q.poll();
                    if ((level % 2) == 0) {
                        levelNodes.add(current.val);
                    } else {
                        levelNodes.add(0, current.val);
                    }

                    if (current.left != null) {
                        q.add(current.left);
                    }
                    if (current.right != null) {
                        q.add(current.right);
                    }
                }

                ans.add(levelNodes);
                level++;
            }
            return ans;
        }
    }

    class Solution1 {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            traverse(root, 0, ans);
            return ans;
        }

        private void traverse(TreeNode root, int level, List<List<Integer>> ans) {
            if (root == null) return;

            if (ans.size() <= level) {
                ans.add(new LinkedList<>());
            }

            List<Integer> levelNodes = ans.get(level);

            if (level % 2 == 0) {
                levelNodes.add(root.val);
            } else {
                levelNodes.add(0, root.val);
            }

            traverse(root.left, level + 1, ans);
            traverse(root.right, level + 1, ans);
        }

    }
}
