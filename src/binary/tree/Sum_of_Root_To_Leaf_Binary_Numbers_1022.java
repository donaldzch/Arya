package binary.tree;

import java.util.LinkedList;


import java.util.Queue;

class Sum_of_Root_To_Leaf_Binary_Numbers_1022 {
    class Solution {
        public int sumRootToLeaf(TreeNode root) {
            int result = 0;
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            Queue<Integer> queue = new LinkedList<>();

             nodeQueue.offer(root);
             queue.offer(root.val);

            while (!queue.isEmpty()) {
                TreeNode current = nodeQueue.poll();
                Integer value = queue.poll();

                if (current.left == null && current.right == null) {
                    result += value;
                } else {
                    if (current.left != null) {
                        nodeQueue.offer(current.left);
                        queue.offer((value << 2) + current.left.val);
                    }
                    if (current.right != null) {
                        nodeQueue.offer(current.right);
                        queue.offer((value << 2) + current.right.val);
                    }
                }
            }

            return result;
        }
    }

    class Solution1 {
        public int sumRootToLeaf(TreeNode root) {
            return dfs(root, 0);
        }

        private int dfs(TreeNode node, int sum) {
            if (node == null) {
                return 0;
            }

            int parentSum = sum << 1 | node.val;

            if (node.left == null && node.right == null) {
                return parentSum;
            }

            return dfs(node.left, parentSum) + dfs(node.right, parentSum);
        }
    }
}