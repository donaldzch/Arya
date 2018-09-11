package binary.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length)
                return null;
            return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);

        }

        private TreeNode buildTree(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
            if (ps > pe || is > ie) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[ps]);
            int pos;
            for (pos = is; pos <= ie; pos++) {
                if (inorder[pos] == root.val)
                    break;
            }

            root.left = buildTree(preorder, inorder, ps + 1, ps + pos - is, is + pos - 1, pos);
            root.right = buildTree(preorder, inorder, pe - ie + pos + 1, pe, pos + 1, pe);

            return root;
        }
    }

    class Solution1 {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode root = new TreeNode(preorder[0]);

            Map<Integer, Integer> inorderMap = new HashMap<>();

            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }

            stack.push(root);

            for (int i = 1; i < preorder.length; i++) {
                int value = preorder[i];
                TreeNode node = new TreeNode(value);
                if (inorderMap.get(value) < inorderMap.get(stack.peek().val)) {
                    stack.peek().left = node;
                } else {
                    TreeNode parent = null;

                    while (!stack.isEmpty() && inorderMap.get(value) > inorderMap.get(stack.peek().val)) {
                        parent = stack.pop();
                    }
                    parent.right = node;
                }
                stack.push(node);
            }

            return root;
        }
    }
}
