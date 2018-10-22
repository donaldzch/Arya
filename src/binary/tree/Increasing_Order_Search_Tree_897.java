package binary.tree;

import java.util.Stack;

public class Increasing_Order_Search_Tree_897 {
    class Solution {
        public TreeNode increasingBST(TreeNode root) {
            if (root == null)
                return null;

            TreeNode[] ans = new TreeNode[2];

            inorder(root, ans);

            return ans[1];
        }

        private void inorder(TreeNode root, TreeNode[] ans) {
            if (root == null)
                return;
            inorder(root.left, ans);
            if (ans[0] != null) {
                //prev is not null
                ans[0].right = root;
            }
            root.left = null;
            ans[0] = root;
            if (ans[1] == null) {
                ans[1] = root;//new root
            }
            inorder(root.right, ans);
        }
    }

    class Solution1 {
        public TreeNode increasingBST(TreeNode root) {
            if (root == null) {
                return null;
            }

            Stack<TreeNode> stack = new Stack<>();

            TreeNode cur = root;

            TreeNode prev = null;

            TreeNode head = null;

            while (!stack.isEmpty() || cur != null) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }

                cur = stack.pop();

                if (prev != null) {
                    prev.right = cur;
                }

                cur.left = null;
                prev = cur;

                if (head == null) {
                    head = cur;
                }

                cur = cur.right;
            }

            return head;
        }
    }
}
