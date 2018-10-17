package binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Maximum_Width_of_Binary_Tree_662 {
    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            List<Integer> leftNodes = new ArrayList<>();

            if (root == null)
                return 0;

            return dfs(root, 0, 0, leftNodes);
        }

        private int dfs(TreeNode root, int depth, int index, List<Integer> leftNodes) {
            if (root == null)
                return 0;

            if (depth >= leftNodes.size()) {
                //left-most node
                leftNodes.add(index);
            }
            int left = dfs(root.left, depth + 1, index * 2, leftNodes);
            int right = dfs(root.right, depth + 1, index * 2 + 1, leftNodes);
            return Math.max(index - leftNodes.get(depth) + 1, Math.max(left, right));
        }
    }

    class Solution1 {
        public int widthOfBinaryTree(TreeNode root) {
            if (root == null)
                return 0;

            int ans = Integer.MIN_VALUE;

            Queue<TreeNode> qNode = new LinkedList<>();
            Queue<Integer> qIndex = new LinkedList<>();

            qNode.offer(root);
            qIndex.offer(0);

            while (!qNode.isEmpty()) {
                int size = qNode.size();
                int leftMost = qIndex.peek(), index = leftMost;
                for (int i = 0; i < size; i++) {
                    TreeNode node = qNode.poll();
                    index = qIndex.poll();
                    if (node.left != null) {
                        qNode.offer(node.left);
                        qIndex.offer(index * 2);
                    }
                    if (node.right != null) {
                        qNode.offer(node.right);
                        qIndex.offer(index * 2 + 1);
                    }
                }
                ans = Math.max(ans, index - leftMost + 1);
            }

            return ans;
        }
    }
}
