package binary.tree;

import java.util.Deque;
import java.util.LinkedList;

public class Maximum_Binary_Tree_654 {
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            Deque<TreeNode> stack = new LinkedList<>();

            for (int i = 0; i < nums.length; i++) {
                TreeNode node = new TreeNode(nums[i]);

                while (!stack.isEmpty() && stack.peek().val < nums[i]) {
                    node.left = stack.pop();
                }

                if (!stack.isEmpty()) {
                    stack.peek().right = node;
                }

                stack.push(node);
            }

            return stack.isEmpty() ? null : stack.removeLast();
        }
    }

    class Solution1 {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return construct(nums, 0, nums.length);
        }

        private TreeNode construct(int[] nums, int left, int right) {
            if (left == right)
                return null;

            int maxIndex = maxIndex(nums, left, right);
            TreeNode node = new TreeNode(nums[maxIndex]);

            node.left = construct(nums, left, maxIndex);
            node.right = construct(nums, maxIndex + 1, right);

            return node;
        }

        private int maxIndex(int[] nums, int left, int right) {
            int index = left;

            for (int i = left + 1; i < right; i++) {
                if (nums[index] < nums[i]) {
                    index = i;
                }
            }
            return index;
        }
    }
}
