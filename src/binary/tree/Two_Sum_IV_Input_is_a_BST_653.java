package binary.tree;

import java.util.*;

public class Two_Sum_IV_Input_is_a_BST_653 {

    /**
     * Definition for a binary tree node.
     *
     */
     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return findTarget(root, k, set);
    }

    private boolean findTarget(TreeNode node, int k, Set<Integer> set) {
         if (node == null) {
             return false;
         }
         if (set.contains(k - node.val))
             return true;
         set.add(node.val);
         return findTarget(node.left, k, set) || findTarget(node.right, k, set);
    }

    public boolean findTarget1(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (set.contains(k - node.val))
                return true;
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
            set.add(node.val);
        }
        return false;
    }

    public boolean findTarget2(TreeNode root, int k) {
         List<Integer> list = new ArrayList<>();
         inorder(root, list);
         int i = 0, j = list.size() - 1;
         while (i < j) {
             int s = list.get(i), t = list.get(j);
             if (s + t == k) {
                 return true;
             }
             if (s + t > k)
                 j--;
             else
                 i++;
         }
         return false;
    }

    private void inorder(TreeNode root, List<Integer> list) {
         if (root == null) return;
         inorder(root.left, list);
         list.add(root.val);
         inorder(root.right, list);
    }
}
