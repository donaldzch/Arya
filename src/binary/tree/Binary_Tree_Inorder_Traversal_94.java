package binary.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Inorder_Traversal_94 {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            inorder(root, ans);
            return ans;
        }

        private void inorder(TreeNode root, List<Integer> ans) {
            if (root == null) return;
            inorder(root.left, ans);
            ans.add(root.val);
            inorder(root.right, ans);
        }
    }

    class Solution1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null)
                return ans;

            Stack<TreeNode> stack = new Stack<>();
            TreeNode current = root;

            while (current != null || !stack.empty()) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                ans.add(current.val);
                current = current.right;
            }

            return ans;
        }
    }

    class Solution2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();

            if (root == null)
                return ans;

            TreeNode current, previous;

            current = root;

            while (current != null) {
                if (current.left == null) {
                    ans.add(current.val);
                    current = current.right;
                } else {
                    /* Find the inorder predecessor of current */
                    previous = current.left;
                    while (previous.right != null && previous.right != current)
                        previous = previous.right;

                    /* Make current as right child of its inorder predecessor */
                    if (previous.right == null) {
                        previous.right = current;
                        current = current.left;
                    }

                 /* Revert the changes made in if part to restore the
                    original tree i.e.,fix the right child of predecssor*/
                    else {
                        previous.right = null;
                        ans.add(current.val);
                        current = current.right;
                    }   /* End of if condition pre->right == NULL */
                }
            }

            return ans;
        }
    }
}
