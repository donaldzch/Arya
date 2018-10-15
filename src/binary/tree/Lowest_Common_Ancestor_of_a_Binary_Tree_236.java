package binary.tree;

import java.util.*;

public class Lowest_Common_Ancestor_of_a_Binary_Tree_236 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null)
                return null;
            if (root == p || root == q)
                return root;

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (left != null && right != null)
                return root;

            if (left == null && right == null)
                return null;

            return left != null ? left : right;
        }
    }

    class Solution1 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            Map<TreeNode, TreeNode> parentMap = new HashMap<>();
            Queue<TreeNode> queue = new LinkedList<>();

            if (root == null)
                return null;
            parentMap.put(root, null);
            queue.offer(root);

            while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
                TreeNode cur = queue.poll();

                if (cur.left != null) {
                    parentMap.put(cur.left, cur);
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    parentMap.put(cur.right, cur);
                    queue.offer(cur.right);
                }
            }

            Set<TreeNode> ancestorSet = new HashSet<>();

            while (p != null) {
                ancestorSet.add(p);
                p = parentMap.get(p);
            }

            while (!ancestorSet.contains(q)) {
                q = parentMap.get(q);
            }

            return q;
        }
    }
}
