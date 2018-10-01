package binary.tree;

import java.util.Stack;

public class Binary_Search_Tree_Iterator_173 {
    public class BSTIterator {

        private Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode cur = stack.pop();

            TreeNode node = cur.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            return cur.val;
        }
    }

}
