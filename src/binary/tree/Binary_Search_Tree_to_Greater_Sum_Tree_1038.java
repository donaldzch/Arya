package binary.tree;

import java.util.ArrayDeque;
import java.util.Deque;

class Binary_Search_Tree_to_Greater_Sum_Tree_1038 {
    class Solution {
        public TreeNode bstToGst(TreeNode root) {
            Deque<TreeNode> deque = new ArrayDeque<>();

            int sum = 0;
            TreeNode current = root;

            while (current != null || !deque.isEmpty()) {
                while (current != null) {
                    deque.push(current);
                    current = current.right;
                }
                current = deque.pop();
                sum += current.val;
                current.val = sum;
                current = current.left;
            }
            return root;
        }
    }
}