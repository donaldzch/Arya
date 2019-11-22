package binary.tree;

import java.util.Map;
import java.util.Queue;

class Cousins_in_Binary_Tree_953 {
    class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            boolean xExist = false;
            boolean yExist = false;

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();

                    if (node.val == x) {
                        xExist = true;
                    }

                    if (node.val == y) {
                        yExist = true;
                    }

                    if (node.left != null && node.right != null) {
                        if (node.left.val == x && node.right.val == y) {
                            return false;
                        }
                        if (node.left.val == y && node.right.val == x) {
                            return false;
                        }
                    }

                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                if (xExist && yExist) {
                    return true;
                } 
                if (xExist || yExist) {
                    return false;
                }
            }
            return false;
        }
    }

    class Solution1 {
        public boolean isCousins(TreeNode root, int x, int y) {
            Map<Integer, Integer> depth = new HashMap<>();
            Map<Integer, Integer> parent = new HashMap<>();
            dfs(root, null, depth, parent);
            return depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y);
        }

        private void dfs(TreeNode root, TreeNode parentNode, Map<Integer, Integer> depth, Map<Integer, Integer> parent) {
            if (root != null) {
                depth.put(root.val, parentNode != null ? 1 + depth.get(parentNode.val) : 0);
                parent.put(root.val, parentNode != null ? parentNode.val : null);
                dfs(root.left, root, depth, parent);
                dfs(root.right, root, depth, parent);
            }
        }
    }
}