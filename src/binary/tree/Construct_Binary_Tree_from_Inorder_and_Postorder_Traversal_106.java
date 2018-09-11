package binary.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106 {
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length)
                return null;

            Map<Integer, Integer> inorderMap = new HashMap<>();

            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }

            return buildTree(inorder, 0, inorder.length - 1,
                    postorder, 0, postorder.length - 1, inorderMap);
        }

        private TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, Map<Integer, Integer> inorderMap) {
            if (is > ie || ps > pe) {
                return null;
            }
            int value = postorder[pe];
            TreeNode root = new TreeNode(value);
            int pos = inorderMap.get(value);

            root.left = buildTree(inorder, is, pos - 1, postorder, ps, pe - ie + pos - 1, inorderMap);
            root.right = buildTree(inorder, pos + 1, ie, postorder, pe - ie + pos, pe - 1, inorderMap);

            return root;
        }
    }

    class Solution1 {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length)
                return null;

            Map<Integer, Integer> inorderMap = new HashMap<>();

            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }

            TreeNode root = new TreeNode(postorder[postorder.length - 1]);

            Stack<TreeNode> stack = new Stack<>();

            stack.push(root);

            for (int i = postorder.length - 2; i >= 0; i--) {
                TreeNode node = new TreeNode(postorder[i]);
                if (inorderMap.get(node.val) > inorderMap.get(stack.peek().val)) {
                    stack.peek().right = node;
                } else {
                    TreeNode parent = null;
                    while (!stack.isEmpty() && inorderMap.get(node.val) < inorderMap.get(stack.peek().val)) {
                        parent = stack.pop();
                    }
                    parent.left = node;
                }
                stack.push(node);
            }

            return root;
        }
    }
}
