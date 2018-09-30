package binary.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Preorder_Traversal_144 {
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();

            if (root == null) {
                return ans;
            }

            TreeNode cur, prev;

            cur = root;

            while (cur != null) {
                if (cur.left == null) {
                    ans.add(cur.val);
                    cur = cur.right;
                } else {
                    prev = cur.left;
                    while (prev.right != null && prev.right != cur) {
                        prev = prev.right;
                    }

                    if (prev.right == null) {
                        ans.add(cur.val);
                        prev.right = cur;
                        cur = cur.left;
                    } else {
                        prev.right = null;
                        cur = cur.right;
                    }
                }
            }

            return ans;
        }
    }

    class Solution2 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();

            if (root == null)
                return ans;

            Stack<TreeNode> stack = new Stack<>();

            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();

                while (cur != null) {
                    ans.add(cur.val);
                    if (cur.right != null)
                        stack.push(cur.right);
                    cur = cur.left;
                }
            }

            return ans;
        }
    }

    class Solution3 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();

            if (root == null)
                return ans;

            Stack<TreeNode> stack = new Stack<>();

            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();

                ans.add(cur.val);

                if (cur.right != null) {
                    stack.push(cur.right);
                }

                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }

            return ans;
        }
    }
}
