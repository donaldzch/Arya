package binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Paths_257 {
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> ans = new ArrayList<>();

            if (root == null)
                return ans;

            Queue<TreeNode> qNode = new LinkedList<>();
            Queue<StringBuilder> qSB = new LinkedList<>();

            qNode.offer(root);
            qSB.offer(new StringBuilder(""));

            while (!qNode.isEmpty()) {
                TreeNode cur = qNode.poll();
                StringBuilder sb = qSB.poll();

                sb.append(cur.val);

                if (cur.left == null && cur.right == null) {
                    ans.add(sb.toString());
                }

                if (cur.left != null) {
                    qNode.offer(cur.left);
                    qSB.offer(new StringBuilder(sb.toString() + "->"));
                }

                if (cur.right != null) {
                    qNode.offer(cur.right);
                    qSB.offer(new StringBuilder(sb.toString() + "->"));
                }
            }

            return ans;
        }
    }

    class Solution1 {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> ans = new ArrayList<>();
            dfs(root, ans, "");
            return ans;
        }

        private void dfs(TreeNode root, List<String> ans, String prev) {
            if (root.left == null && root.right == null) {
                ans.add(prev + root.val);
            }
            if (root.left != null) {
                dfs(root.left, ans, prev + root.val + "->");
            }
            if (root.right != null) {
                dfs(root.right, ans, prev + root.val + "->");
            }
        }
    }
}
