package binary.tree;

import java.util.LinkedList;
import java.util.Queue;

class Deepest_Leaves_Sum_1302 {
    class Solution {
        public int deepestLeavesSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            int sum = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                sum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            return sum;
        }
    }

    class Solution1 {
        private void dfs(TreeNode node, int[] sumOfLeaves, int[] maxDepth, int depth) {
            if (node == null) {
                return;
            }
            if (node.left == null && node.right == null) {
                if (maxDepth[0] == depth) {
                    sumOfLeaves[0] += node.val;
                } else if (maxDepth[0] > depth) {
                    return;
                } else {
                    sumOfLeaves[0] = node.val;
                    maxDepth[0] = depth;
                }
            }
            dfs(node.left, sumOfLeaves, maxDepth, depth + 1);
            dfs(node.right, sumOfLeaves, maxDepth, depth + 1);
        }

        public int deepestLeavesSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int[] sum = new int[1];
            int[] maxDepth = new int[1];
            dfs(root, sum, maxDepth, 1);
            return sum[0];
        }

        
    }
}