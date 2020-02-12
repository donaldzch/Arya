package binary.tree;

import java.util.*;

class Check_Completeness_of_a_Binary_Tree_958 {
    class Solution {
        public boolean isCompleteTree(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();

            q.offer(root);

            boolean end = false;

            while (!q.isEmpty()) {
                TreeNode cur = q.poll();
                if (cur == null) {
                    end = true;
                } else {
                    if (end) {
                        return false;
                    }
                    q.offer(cur.left);
                    q.offer(cur.right);
                }
            }

            return true;
        }
    }
}