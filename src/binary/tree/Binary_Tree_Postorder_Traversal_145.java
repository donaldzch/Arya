package binary.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Postorder_Traversal_145 {
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new LinkedList<>();

            if (root == null)
                return ans;

            TreeNode cur, prev;

            cur = root;

            while (cur != null) {
                if (cur.right == null) {
                    ans.add(0, cur.val);
                    cur = cur.left;
                } else {
                    prev = cur.right;
                    while (prev.left != null && prev.left != cur) {
                        prev = prev.left;
                    }
                    if (prev.left == null) {
                        ans.add(0, cur.val);
                        prev.left = cur;
                        cur = cur.right;
                    } else {
                        prev.left = null;
                        cur = cur.left;
                    }
                }
            }
            return ans;
        }
    }

    class Solution1 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new LinkedList<>();

            if (root == null)
                return ans;

            Stack<TreeNode> stack = new Stack<>();

            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();

                ans.add(0, cur.val);

                if (cur.left != null) {
                    stack.push(cur.left);
                }

                if (cur.right != null) {
                    stack.push(cur.right);
                }
            }

            return ans;
        }
    }

    class Solution2 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new LinkedList<>();

            if (root == null)
                return ans;

            Stack<TreeNode> stack = new Stack<>();

            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();

                while (cur != null) {
                    ans.add(0, cur.val);
                    if (cur.left != null) {
                        stack.push(cur.left);
                    }
                    cur = cur.right;
                }
            }

            return ans;
        }
    }
}
