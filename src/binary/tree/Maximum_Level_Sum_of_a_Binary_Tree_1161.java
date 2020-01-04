package binary.tree;

import java.util.LinkedList;
import java.util.Queue;

class Maximum_Level_Sum_of_a_Binary_Tree_1161 {
    class Solution {
        public int maxLevelSum(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            int maxSum = 0;
            int maxLevel = 0;

            queue.offer(root);
            int level = 0;
            int levelSum = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                level++;
                levelSum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    levelSum += node.val;
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                if (levelSum > maxSum) {
                    maxSum = levelSum;
                    maxLevel = level;
                }
            }
            return maxLevel;
        }
    }
}